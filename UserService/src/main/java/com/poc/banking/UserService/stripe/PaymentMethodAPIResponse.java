package com.poc.banking.UserService.stripe;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentMethodAPIResponse {

    private String object;
    private List<PaymentMethod> data;
    @JsonProperty("has_more")
    private boolean hasMore;
    private String url;

    // Getters and Setters

    public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public List<PaymentMethod> getData() {
		return data;
	}
	public void setData(List<PaymentMethod> data) {
		this.data = data;
	}
	public boolean isHasMore() {
		return hasMore;
	}
	public void setHasMore(boolean hasMore) {
		this.hasMore = hasMore;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public static class PaymentMethod {
        private String id;
        private String object;
        @JsonProperty("allow_redisplay")
        private String allowRedisplay;
        @JsonProperty("billing_details")
        private BillingDetails billingDetails;
        private Card card;
        private long created;
        private String customer;
        private boolean livemode;
        private Metadata metadata;
        private String type;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getObject() {
			return object;
		}
		public void setObject(String object) {
			this.object = object;
		}
		public String getAllowRedisplay() {
			return allowRedisplay;
		}
		public void setAllowRedisplay(String allowRedisplay) {
			this.allowRedisplay = allowRedisplay;
		}
		public BillingDetails getBillingDetails() {
			return billingDetails;
		}
		public void setBillingDetails(BillingDetails billingDetails) {
			this.billingDetails = billingDetails;
		}
		public Card getCard() {
			return card;
		}
		public void setCard(Card card) {
			this.card = card;
		}
		public long getCreated() {
			return created;
		}
		public void setCreated(long created) {
			this.created = created;
		}
		public String getCustomer() {
			return customer;
		}
		public void setCustomer(String customer) {
			this.customer = customer;
		}
		public boolean isLivemode() {
			return livemode;
		}
		public void setLivemode(boolean livemode) {
			this.livemode = livemode;
		}
		public Metadata getMetadata() {
			return metadata;
		}
		public void setMetadata(Metadata metadata) {
			this.metadata = metadata;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}

    }

    public static class BillingDetails {
        private Address address;
        private String email;
        private String name;
        private String phone;
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}

        // Getters and Setters
    }

    public static class Address {
        private String city;
        private String country;
        private String line1;
        private String line2;
        @JsonProperty("postal_code")
        private String postalCode;
        private String state;
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getLine1() {
			return line1;
		}
		public void setLine1(String line1) {
			this.line1 = line1;
		}
		public String getLine2() {
			return line2;
		}
		public void setLine2(String line2) {
			this.line2 = line2;
		}
		public String getPostalCode() {
			return postalCode;
		}
		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}

        // Getters and Setters
    }
    public static class Card {
        private String brand;
        private Checks checks;
        private String country;
        @JsonProperty("display_brand")
        private String displayBrand;
        @JsonProperty("exp_month")
        private int expMonth;
        @JsonProperty("exp_year")
        private int expYear;
        private String fingerprint;
        public String getBrand() {
			return brand;
		}
		public void setBrand(String brand) {
			this.brand = brand;
		}
		public Checks getChecks() {
			return checks;
		}
		public void setChecks(Checks checks) {
			this.checks = checks;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getDisplayBrand() {
			return displayBrand;
		}
		public void setDisplayBrand(String displayBrand) {
			this.displayBrand = displayBrand;
		}
		public int getExpMonth() {
			return expMonth;
		}
		public void setExpMonth(int expMonth) {
			this.expMonth = expMonth;
		}
		public int getExpYear() {
			return expYear;
		}
		public void setExpYear(int expYear) {
			this.expYear = expYear;
		}
		public String getFingerprint() {
			return fingerprint;
		}
		public void setFingerprint(String fingerprint) {
			this.fingerprint = fingerprint;
		}
		public String getFunding() {
			return funding;
		}
		public void setFunding(String funding) {
			this.funding = funding;
		}
		public String getGeneratedFrom() {
			return generatedFrom;
		}
		public void setGeneratedFrom(String generatedFrom) {
			this.generatedFrom = generatedFrom;
		}
		public String getLast4() {
			return last4;
		}
		public void setLast4(String last4) {
			this.last4 = last4;
		}
		public Networks getNetworks() {
			return networks;
		}
		public void setNetworks(Networks networks) {
			this.networks = networks;
		}
		public ThreeDSecureUsage getThreeDSecureUsage() {
			return threeDSecureUsage;
		}
		public void setThreeDSecureUsage(ThreeDSecureUsage threeDSecureUsage) {
			this.threeDSecureUsage = threeDSecureUsage;
		}
		public String getWallet() {
			return wallet;
		}
		public void setWallet(String wallet) {
			this.wallet = wallet;
		}
		private String funding;
        @JsonProperty("generated_from")
        private String generatedFrom;
        private String last4;
        private Networks networks;
        @JsonProperty("three_d_secure_usage")
        private ThreeDSecureUsage threeDSecureUsage;
        private String wallet;

        
    }
    public static class Checks {
        @JsonProperty("address_line1_check")
        private String addressLine1Check;
        @JsonProperty("address_postal_code_check")
        private String addressPostalCodeCheck;
        @JsonProperty("cvc_check")
        private String cvcCheck;
		public String getAddressLine1Check() {
			return addressLine1Check;
		}
		public void setAddressLine1Check(String addressLine1Check) {
			this.addressLine1Check = addressLine1Check;
		}
		public String getAddressPostalCodeCheck() {
			return addressPostalCodeCheck;
		}
		public void setAddressPostalCodeCheck(String addressPostalCodeCheck) {
			this.addressPostalCodeCheck = addressPostalCodeCheck;
		}
		public String getCvcCheck() {
			return cvcCheck;
		}
		public void setCvcCheck(String cvcCheck) {
			this.cvcCheck = cvcCheck;
		}

        // Getters and Setters
    }
    public static class Networks {
        private List<String> available;
        private String preferred;
		public List<String> getAvailable() {
			return available;
		}
		public void setAvailable(List<String> available) {
			this.available = available;
		}
		public String getPreferred() {
			return preferred;
		}
		public void setPreferred(String preferred) {
			this.preferred = preferred;
		}

        // Getters and Setters
    }
    public static class ThreeDSecureUsage {
        private boolean supported;

		public boolean isSupported() {
			return supported;
		}

		public void setSupported(boolean supported) {
			this.supported = supported;
		}

        // Getters and Setters
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Metadata {
        // Assuming it's an empty object; otherwise, add fields here
    }
}
