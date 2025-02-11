package com.poc.banking.UserService.transfer.service;

import java.util.concurrent.CompletableFuture;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poc.banking.UserService.KafkaAdminConfig;
import com.poc.banking.UserService.entity.Account;
import com.poc.banking.UserService.entity.UserDetails;
import com.poc.banking.UserService.entity.dto.AccountDto;
import com.poc.banking.UserService.model.AccountTransactionModel;
import com.poc.banking.UserService.repo.AccountRepository;

@Service
public class AccountService {
	 private final Log log = LogFactory.getLog(getClass());
    @Autowired
    private AccountRepository accountRepository;

    private KafkaTemplate<String,AccountTransactionModel> kafkaTemplate;
    
    @Transactional
    public Account createAccount(AccountDto accountDto, UserDetails userDetails) {
    	log.debug("create account");
    	Account account = new Account();
		   Account.BillingDetails billingDetails = new Account.BillingDetails();
	        billingDetails.setName(accountDto.getBillingDetails().getName());
	        billingDetails.setEmail(accountDto.getBillingDetails().getEmail());
	        billingDetails.setPhone(accountDto.getBillingDetails().getPhone());

	        Account.BillingDetails.Address address =  new Account.BillingDetails.Address();
	        address.setCity(accountDto.getBillingDetails().getAddress().getCity());
	        address.setCountry(accountDto.getBillingDetails().getAddress().getCountry());
	        billingDetails.setAddress(address);

//	        Account.UsBankAccount usBankAccount = new Account.UsBankAccount();
//	        usBankAccount =accountDto.getUsBankAccount();
////	        usBankAccount.setLast4(accountDto.getUsBankAccount().getLast4());
////	        
	        
	        account.setBillingDetails(billingDetails);
	        account.setUsBankAccount(accountDto.getUsBankAccount());
	        account.setAccountNumber(accountDto.getAccountNumber());
	        
        account.setUserDetails(userDetails);
      //  account.setType();
        account.setBillingDetails(billingDetails);
        account.setUsBankAccount(accountDto.getUsBankAccount());

        return accountRepository.save(account);
    }
    
    //send to kafka , it not real time use case
    public void  sendMessage(Account account) {
    	CompletableFuture<SendResult<String, AccountTransactionModel>> future =	 kafkaTemplate.send(KafkaAdminConfig.ACCOUNT_ADDED,buildAccountMainModel(account));
    	future.thenApply(result -> {
            System.out.println("Message sent successfully! " +
                    "Topic: " + result.getRecordMetadata().topic() +
                    ", Partition: " + result.getRecordMetadata().partition() +
                    ", Offset: " + result.getRecordMetadata().offset());
            return result;
        }).exceptionally(ex -> {
            System.err.println("Failed to send message: " + ex.getMessage());
            return null; // Return null or handle the failure case as needed
        });
    	
    }
    
    AccountTransactionModel buildAccountMainModel(Account account) {
    	AccountTransactionModel accountTransactionModel = new AccountTransactionModel();
    	accountTransactionModel.setAccountNumber(Long.parseLong(account.getAccountNumber()));
    	accountTransactionModel.setAccountId(account.getId());
    	accountTransactionModel.setAccountType(account.getUsBankAccount().getAccountType());
    	return accountTransactionModel;
    }
}
