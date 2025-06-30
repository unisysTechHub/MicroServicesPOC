package com.poc.banking.UserService.transfer.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poc.banking.UserService.UserDetailsFluentQueryAPI;
import com.poc.banking.UserService.entity.Beneficiaries;
import com.poc.banking.UserService.entity.UserDetails;
import com.poc.banking.UserService.enums.TransactionConstants;
import com.poc.banking.UserService.model.Beneficiary;
import com.poc.banking.UserService.model.Transaction;
import com.poc.banking.UserService.repo.BeneficiariesRepository;
import com.poc.banking.UserService.repo.UserRepository;
import com.poc.banking.UserService.response.BaseResponse;
import com.poc.banking.UserService.response.BeneficiaryListResponse;
import com.poc.banking.UserService.transfer.response.BeneficiaryModel;
import com.poc.banking.UserService.transfer.response.BeneficiaryResponseModel;
import com.poc.banking.UserService.transfer.validation.group.Domestic;

import io.micrometer.core.ipc.http.HttpSender.Response;

@Repository
public class BeneficiariesServiceImpl implements BeneficiariesService {
	@Autowired
    private UserRepository userDetailsRepository;

	@Autowired
	UserDetailsFluentQueryAPI userDetailsqueryAPI;
    @Autowired
    private BeneficiariesRepository beneficiariesRepository;
    
    @Autowired
    private BeneficiariesValidtionService validationService;

    public BeneficiaryResponseModel addBeneficiary( Beneficiary beneficiary) {
    	System.out.println("@Ramesh" + beneficiary.getBankName());
    	UserDetails userDetails = userDetailsqueryAPI.isValidUser(new UserDetails("user123"));
        
        // Create a new Beneficiary
        
        Beneficiaries beneficiaries = null;

    	try {
    		switch (beneficiary.getTransferType()) {
            case TransactionConstants.TransactionType.INTRA:
            case TransactionConstants.TransactionType.INTERNAL:
            case TransactionConstants.TransactionType.DOMESTIC_ACH:
            case TransactionConstants.TransactionType.DOMESTIC_WIRE:
            	validationService.validateBeneficiary(beneficiary,Domestic.class); 
                beneficiaries = validationService.addDomesticBeneficiary(beneficiary);

                break;
            case TransactionConstants.TransactionType.INTERNATIONAL:
                
            	
            default:
                throw new IllegalArgumentException("Unsupported transfer type: " + beneficiary.getTransferType());
    		}
    		
    	}
    	catch(IllegalArgumentException e) {
    		
    		
    				return buildErrorResponse(e.getMessage(),"450",beneficiary); 
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return  new BeneficiaryResponseModel(e.getMessage(),"450"); 
		}
    	
    	// Fetch the UserDetails by ID
    	
	
        try {
           
            beneficiaries.setUserDetails(userDetails);
            beneficiariesRepository.save(beneficiaries);

            BeneficiaryResponseModel beneficiariesResponse = buildDomesticResponse(beneficiaries);
            
            return beneficiariesResponse;

        } catch (Exception e) {
            e.printStackTrace();
			return  new BeneficiaryResponseModel(e.getMessage(),"450"); 

        }
}
    

    @Override
	public BeneficiaryListResponse listBeneficiaries(UserDetails user) {
		try {
	        // Fetch user details directly without creating a new object
	        UserDetails userDetails = userDetailsqueryAPI.fetchUserDetilas(user);
	        
	        // Handle null or empty beneficiary list safely
	        List<Beneficiaries> beneficiaries = Optional.ofNullable(userDetails)
	                                                     .map(UserDetails::getBeneficiaryList)
	                                                     .orElse(Collections.emptyList());
	        	        // Build and return success response
	        return buildResponse(beneficiaries, "List beneficiaries successful", "200");
	    } catch (Exception e) {
	        // Build and return error response
	        return new BeneficiaryListResponse(e.getMessage(),"450");
	    }
		
	}    
   
    
    BeneficiaryListResponse buildResponse(List<Beneficiaries> beneficiaries, String message,String responseCode) {
    	List<BeneficiaryModel> beneficiariesList = beneficiaries.stream()
    		                     .map(this::convert)
    		                     .collect(Collectors.toList());
    
       	BeneficiaryListResponse response = new BeneficiaryListResponse();
    	response.setBeneficiarylist(beneficiariesList);
    	response.setMessage(message);
    	response.setResponseCode(responseCode);
    	return response;
    }
    BeneficiaryModel convert(Beneficiaries beneficiaries) {
    	return BeneficiaryMapper.INSTANCE.toBeneficiary(beneficiaries);
    }
    BeneficiaryResponseModel buildDomesticResponse(Beneficiaries beneficiary){
    	BeneficiaryResponseModel response = new BeneficiaryResponseModel.Builder()
    	        .userId(beneficiary.getUserDetails().getUserId())
    	        .accountNumber(beneficiary.getAccountNumber())
    	        .bankName(beneficiary.getBankName())
    	        .beneficiaryName(beneficiary.getBeneficiaryName())
    	        .accountType(beneficiary.getAccountType())
    	        .transferType(beneficiary.getTransferType())
    	        .transferTypeACH(beneficiary.getTransferTypeACH())
    	        .phoneNumber(beneficiary.getPhoneNumber())
    	        .email(beneficiary.getEmail())
    	        .build();

    	System.out.println(beneficiary); // Prints the object details
    	response.setResponseCode("200");
    	response.setMessage("Beneficiary added successfully");
		return response;
    }
    BeneficiaryResponseModel buildErrorResponse(String message,String responseCode,Beneficiary beneficiary ) {
    	BeneficiaryResponseModel response = new BeneficiaryResponseModel();
    	response.setBeneficiary(beneficiary);
    	response.setMessage(message);
    	response.setResponseCode(responseCode);
    	
    	return response;
    }
    
    public String reverString(String string) {
    	  String reversed =  string.chars().mapToObj (c -> (char)c).collect(Collectors.collectingAndThen(Collectors.toList(), 
    			  list -> {
    		    		return list.stream().map(String::valueOf).collect(Collectors.joining()); 
    	  }));
    			  
    	return reversed;
    }
    public static String reverse(String str) {
	    if (str.isEmpty()) return str;
	    return reverse(str.substring(1)) + str.charAt(0);
	}
    public void moreStreamUsecases() {
    	   List<Transaction> transactions = Arrays.asList(
    	            new Transaction("user1", new BigDecimal(100.00)),
    	            new Transaction("user2", new BigDecimal(200.00)),
    	            new Transaction("user1", new BigDecimal(300.00)),
    	            new Transaction("user3", new BigDecimal(400.00)),
    	            new Transaction("user2", new BigDecimal(500.00))
    	        );
    	   
    	 

    	   Map<String, BigDecimal> totalByUser = transactions.stream()
    			    .collect(
    			        HashMap::new,
    			        (map, txn) -> map.merge(
    			            txn.getUserDetails().getUserId(),
    			            txn.getAmount(),
    			            BigDecimal::add
    			        ),
    			        (map1, map2) -> map2.forEach(
    			            (key, value) -> map1.merge(key, value, BigDecimal::add)
    			        )
    			    );
    	   totalByUser.forEach((key,value) -> {System.out.println(key + " ");  System.out.print(value); });
    	   Map<String, BigDecimal> totalByUser1 = transactions.parallelStream()
    			    .collect(
    			        ConcurrentHashMap::new,
    			        (map, txn) -> map.merge(txn.getUserDetails().getUserId(), txn.getAmount(), BigDecimal::add),
    			        (map1, map2) -> map2.forEach(
    			            (key, value) -> map1.merge(key, value, BigDecimal::add)
    			        )
    			    );


       }
	
}
