package com.banking.auth.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.auth.entity.User;
import com.banking.auth.entity.UserRole;
import com.banking.auth.jwt.service.JwtService;
import com.banking.auth.repo.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    
    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthRequest authRequest) {
        authenticate(authRequest.getUsername(), authRequest.getPassword());

//    	 User user = userRepository.findByUsername(authRequest.getUsername())
//                 .orElseThrow(() -> new RuntimeException("User not found"));
        UserDetails user = userDetailsService.loadUserByUsername(authRequest.getUsername());

         
//         List<String> roles = user.getUserRoles().stream()
//                 .map(userRole -> userRole.getRole().getRoleName())
//                 .collect(Collectors.toList());
//
//         if (!roles.contains(authRequest.getRole())) {
//             return ResponseEntity.badRequest().body("User does not have the specified role");
//         }

         

         String token = jwtService.generateToken(user);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @RequestMapping("/list")
    public ResponseEntity<Set<UserRole>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll().get(0).getUserRoles());
    }
    @GetMapping("/message")
    public ResponseEntity<String> showMessage() {
        return ResponseEntity.ok("Hello! This is a custom message from the User API.");
    }
    private void authenticate(String username, String password) {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
        	authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
          

        } catch (DisabledException e) {
          throw new AuthenticationException("USER_DISABLED", null);
        } catch (BadCredentialsException e) {
         throw new AuthenticationException("INVALID_CREDENTIALS", e);
        }
      }
}
