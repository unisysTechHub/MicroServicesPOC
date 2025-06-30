package com.banking.auth.jwt.service;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.*;
import java.time.Clock;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

@Service
public class JwtService implements Serializable {

    private static final long serialVersionUID = -3301605591108950415L;
    static final String CLAIM_KEY_USERNAME = "sub";
    static final String CLAIM_KEY_CREATED = "iat";

    private Clock clock = Clock.systemDefaultZone();
    private PrivateKey privateKey;
    private PublicKey publicKey;
    
    SecretKey signingkey = null;
    String base64encoded= null;
       
   // @Value("${jwt.token.expiration.in.seconds}")
    private Long expiration=216000L;
    
    FileService fileService ;
    
    private static final String SECRET_KEY_BASE64 = "671491AE98362741F722202EED3288E8FF2508B35315ADBF75EEB3195A926B40";


    // Load RSA Private Key
    public Key getSecretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY_BASE64);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private String readKeyFromFile(String path) throws IOException {
        try (InputStream is = new ClassPathResource(path).getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            return br.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()));
        claims.forEach((key,value) -> System.out.println(key+" @Ramesh" + value));
        System.out.println("use name " + userDetails.getUsername());
        return doGenerateToken(claims, userDetails.getUsername());
    }
    private String getSigningKey() {
        byte[] keyBytes ="ThisIsASecretKeyThatIs32BytesLong!".getBytes(StandardCharsets.UTF_8);
        signingkey = Keys.hmacShaKeyFor(keyBytes);
        base64encoded = Encoders.BASE64.encode(signingkey.getEncoded());
        return base64encoded;
    }

    @SuppressWarnings("deprecation")
	private String doGenerateToken(Map<String, Object> claims, String subject) {
        final Date createdDate = Date.from(clock.instant());
        final Date expirationDate = calculateExpirationDate(createdDate);
    System.out.println("Subject" + subject);
        try {
        	return Jwts
                    .builder()
                    .setSubject(subject)
                    .setClaims(claims)
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24 * 90))
                    .signWith(getSecretKey(), SignatureAlgorithm.HS256)
                    .compact();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
			
		}
    }

    private Date calculateExpirationDate(Date createdDate) {
        return new Date(createdDate.getTime() + expiration * 1000);
    }

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getIssuedAtDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getIssuedAt);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
    @PostConstruct
    public void init() {
        System.out.println("JWT Expiration: " + expiration);
    }
    private Claims getAllClaimsFromToken(String token) {
    	System.out.println(signingkey);
        try {
			return Jwts.parser()
			        .setSigningKey(getSecretKey()) // Use publicKey here if you're verifying RS256
			        .parseClaimsJws(token)
			        .getBody();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return (Claims) new HashMap();
		}
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
    	return true;
//        final String username = getUsernameFromToken(token);
//        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    public String refreshToken(String token) {
        final Claims claims = getAllClaimsFromToken(token);
        claims.setIssuedAt(Date.from(clock.instant()));
        claims.setExpiration(calculateExpirationDate(new Date()));
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.RS256, privateKey)
                .compact();
    }
}
