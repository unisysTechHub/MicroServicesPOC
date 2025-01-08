package com.poc.banking.UserService.transfer.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poc.banking.UserService.entity.Account;
import com.poc.banking.UserService.entity.UserDetails;
import com.poc.banking.UserService.entity.dto.AccountDto;
import com.poc.banking.UserService.repo.AccountRepository;

@Service
public class AccountService {
	 private final Log log = LogFactory.getLog(getClass());
    @Autowired
    private AccountRepository accountRepository;

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

	        Account.UsBankAccount usBankAccount = new Account.UsBankAccount();
	        usBankAccount.setBankName(accountDto.getUsBankAccount().getBankName());
	        usBankAccount.setLast4(accountDto.getUsBankAccount().getLast4());
	        
	        account.setBillingDetails(billingDetails);
	        account.setUsBankAccount(usBankAccount);
	        account.setAccountNumber(accountDto.getAccountNumber());
	        
        account.setUserDetails(userDetails);
      //  account.setType();
        account.setBillingDetails(billingDetails);
        account.setUsBankAccount(usBankAccount);

        return accountRepository.save(account);
    }
}
