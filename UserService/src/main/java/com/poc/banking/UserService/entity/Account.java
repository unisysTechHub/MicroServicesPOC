package com.poc.banking.UserService.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(
	    name = "Account",
	    indexes = @Index(name = "idx_account_id", columnList = "accountNumber")
	)
public class Account {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false,referencedColumnName="userId")
    private UserDetails userDetails;
    
    @Column(unique=true)
    private String accountNumber;
    
        
    @Embedded
    private BillingDetails billingDetails;

    @Embedded
    private UsBankAccount usBankAccount;

    @Column
    private String type;

    @Column
    private Long created;
    
    public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public BillingDetails getBillingDetails() {
		return billingDetails;
	}

	public void setBillingDetails(BillingDetails billingDetails) {
		this.billingDetails = billingDetails;
	}

	public UsBankAccount getUsBankAccount() {
		return usBankAccount;
	}

	public void setUsBankAccount(UsBankAccount usBankAccount) {
		this.usBankAccount = usBankAccount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getCreated() {
		return created;
	}

	public void setCreated(Long created) {
		this.created = created;
	}

	@Embeddable
    public static class BillingDetails {
        @Embedded
        private Address address;

        @Column
        private String email;

        @Column
        private String name;

        @Column
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
		@Embeddable
	    public static class Address {
	        @Column
	        private String city;

	        @Column
	        private String country;

	        @Column
	        private String line1;

	        @Column
	        private String line2;

	        @Column
	        private String postalCode;

	        @Column
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

        // Getters and Setters
    }

        @Embeddable
    public static class UsBankAccount {
    	@JsonProperty("account_holder_type")
        @Column(name = "account_holder_type")
        private String accountHolderType;
    	@JsonProperty("account_type")
        @Column(name = "account_type")
        private String accountType;
    	
    	@JsonProperty("bank_name")
        @Column(name = "bank_name")
        private String bankName;
    	
    	@JsonProperty("financial_connections_account")
        @Column(name = "financial_connections_account")
        private String financialConnectionsAccount;

        @Column(name = "fingerprint")
        private String fingerprint;

        @Column(name = "last4")
        private String last4;

        @Column(name = "routing_number")
        private String routingNumber;

        public String getAccountHolderType() {
			return accountHolderType;
		}

		public void setAccountHolderType(String accountHolderType) {
			this.accountHolderType = accountHolderType;
		}

		public String getAccountType() {
			return accountType;
		}

		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}

		public String getBankName() {
			return bankName;
		}

		public void setBankName(String bankName) {
			this.bankName = bankName;
		}

		public String getFinancialConnectionsAccount() {
			return financialConnectionsAccount;
		}

		public void setFinancialConnectionsAccount(String financialConnectionsAccount) {
			this.financialConnectionsAccount = financialConnectionsAccount;
		}

		public String getFingerprint() {
			return fingerprint;
		}

		public void setFingerprint(String fingerprint) {
			this.fingerprint = fingerprint;
		}

		public String getLast4() {
			return last4;
		}

		public void setLast4(String last4) {
			this.last4 = last4;
		}

		public String getRoutingNumber() {
			return routingNumber;
		}

		public void setRoutingNumber(String routingNumber) {
			this.routingNumber = routingNumber;
		}

		public Networks getNetworks() {
			return networks;
		}

		public void setNetworks(Networks networks) {
			this.networks = networks;
		}

		@Embedded
        private Networks networks;

	    @Embeddable
	    public static class Networks {
	        @Column
	        private String preferred;

	        
	        private String supported;


			public String getPreferred() {
				return preferred;
			}


			public void setPreferred(String preferred) {
				this.preferred = preferred;
			}


			public String getSupported() {
				return supported;
			}


			public void setSupported(String supported) {
				this.supported = supported;
			}

	        // Getters and Setters
	    }
        // Getters and Setters
    }


    // Other fields ...

    // Getters and Setters
}
