package com.poc.banking.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.banking.auth.entity.User;
import com.poc.banking.UserService.entity.Account;
import com.poc.banking.UserService.entity.Account.BillingDetails;
import com.poc.banking.UserService.entity.UserDetails;
import com.poc.banking.UserService.entity.dto.AccountDto;
import com.poc.banking.UserService.kafka.ListenerInspector;
import com.poc.banking.UserService.response.AccountList;
import com.poc.banking.UserService.response.LoginResponse;
import com.poc.banking.UserService.response.NewUser;
import com.poc.banking.UserService.response.ValidateUserResponse;
import com.poc.banking.UserService.stripe.PaymentMethodAPIResponse;
import com.poc.banking.UserService.stripe.PaymentMethodModel;
import com.poc.banking.UserService.stripe.service.StripePaymentService;
import com.poc.banking.UserService.transfer.service.AccountService;
import com.poc.banking.UserService.stripe.PaymentMethodAPI;

@RestController
@RequestMapping(value = "/api/user")
public class MainConroller {
	private static final String KAFKA_BROKER = "localhost:9092"; 
	@Autowired
	UserManagementService userManagementService;

    @Autowired
    private AccountService accountService;

	@Autowired
	StripePaymentService stripePaymentService;
	@Autowired
	ListenerInspector listenerInspector;
	
	@Autowired
	AdminClient adminClient;
	@RequestMapping(value = "/newuser", method = RequestMethod.POST,consumes = "application/json" )
	@ResponseBody
	NewUser addUser(@RequestBody User user) {
		
		System.out.println("@Rameseh controller " + user.getUserId());
		return userManagementService.addNewUser(user);
		
	}
	@RequestMapping(value = "/signup", method = RequestMethod.POST,consumes = "application/json" )
	@ResponseBody
	NewUser addUser(@RequestBody UserDetails user) {
		
		System.out.println("@Rameseh controller " + user.getUserId());
		return userManagementService.addUser(user);
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST , consumes = "application/json")
	@ResponseBody
	LoginResponse login(@RequestBody UserDetails user) {
		System.out.println("@Rameseh controller " + user.getPassword());

		return userManagementService.isValidCredintails(user);
		
	}
	
	@RequestMapping(value = "/accounts", method = RequestMethod.POST , consumes = "application/json")
	@ResponseBody
	AccountList accounts(@RequestBody UserDetails user) {
		System.out.println("@Rameseh controller accounts" + user.getUserId());
		ValidateUserResponse response =	userManagementService.isValidUser(user);
		AccountList acctResponse = new AccountList();
		
		switch (response.getResponseCode()) {
		 
		 case "200" : 
			 acctResponse	 = userManagementService.accountList(user);
		 default :
			 acctResponse.setResponseCode(response.getResponseCode());
			 acctResponse.setMessage(response.getMessage());
		 }
		  
						
		return  acctResponse;
		
	}
	
	@RequestMapping(value = "/addaccount", method = RequestMethod.POST , consumes = "application/json")
   	@ResponseBody
	Account addaccount(@RequestBody AccountDto  accountDto) {
	         	UserDetails userDetails = new UserDetails();
				userDetails.setUserId(accountDto.getUserId());
				 System.out.println("@Ramesesh acccout number " + accountDto.getAccountNumber());
	        return accountService.createAccount(
	        		accountDto,this.validateUser(userDetails).getUserDetails()
	        );
		        
	}
	@RequestMapping(value = "/validateUser", method = RequestMethod.POST , consumes = "application/json")
	@ResponseBody
	ValidateUserResponse validateUser(@RequestBody UserDetails user) {
		System.out.println("@Rameseh Validate user " + user.getUserId());	 
		return userManagementService.isValidUser(user);
		
	}
	@GetMapping(value = "/paymentmethods", consumes = "application/json")
	@ResponseBody
	PaymentMethodAPIResponse PaymentMethodAPI() {
		RestTemplate restTemplate = new RestTemplate();
		  ApiTemplate<PaymentMethodAPIResponse> PaymentMethod = new PaymentMethodAPI(restTemplate);
		  PaymentMethodAPIResponse paymentMethodRespose = PaymentMethod.callApi();
		return paymentMethodRespose;
	}
	
	@GetMapping("/kafka")
	public Map<String, String> checkKafkaHealth() {
//	    Properties props = new Properties();
//	    props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_BROKER);
 listenerInspector.printListenerIds();
	    try {
	        adminClient.listTopics().names().get();
	        return Map.of("status", "UP", "Kafka", "Running" );
	    } catch (ExecutionException | InterruptedException e) {
	        return Map.of("status", "DOWN", "Kafka", "Not Reachable");
	    }
	}
	
}
