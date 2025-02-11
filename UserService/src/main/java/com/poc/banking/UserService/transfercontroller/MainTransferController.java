package com.poc.banking.UserService.transfercontroller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.poc.banking.UserService.entity.Beneficiaries;
import com.poc.banking.UserService.entity.UserDetails;
import com.poc.banking.UserService.model.Beneficiary;
import com.poc.banking.UserService.model.Transaction;
import com.poc.banking.UserService.model.URL;
import com.poc.banking.UserService.repo.UserRepositoryCustom;
import com.poc.banking.UserService.response.BeneficiaryListResponse;
import com.poc.banking.UserService.transfer.response.BeneficiaryResponseModel;
import com.poc.banking.UserService.transfer.response.TransactionResponseModel;
import com.poc.banking.UserService.transfer.service.BeneficiariesService;

@RestController
@RequestMapping(value = "/api/transfer")

public class MainTransferController {

	@Autowired
	BeneficiariesService beneficiariesService;
	@Autowired
	UserRepositoryCustom userRepositoryCustom;
	
	
	
	 private final Log log = LogFactory.getLog(getClass()); 

	@RequestMapping(value = "/addBeneficiary", method = RequestMethod.POST,consumes = "application/json" )
	@ResponseBody
	BeneficiaryResponseModel addBeneficiary(@RequestBody Beneficiary beneficiary) {
		
		System.out.println("@Rameseh controller " + beneficiary.getUserId());
		return beneficiariesService.addBeneficiary(beneficiary);
		
	}
	
	@RequestMapping(value = "/beneficiaries", method = RequestMethod.POST,consumes = "application/json" )
	@ResponseBody
	BeneficiaryListResponse beneficiaryList(@RequestBody UserDetails userDetails) {
		//Beneficiaries  b = userRepositoryCustom.findBeneficiaryByBankname("ABC Bank").get(0);
		//System.out.println("@Ramesh" + b.getAccountNumber());
		System.out.println("@Rameseh controller " + userDetails.getUserId());
		return beneficiariesService.listBeneficiaries(userDetails);
		
	}
	
	@RequestMapping(value= "/initiatetransfer", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	TransactionResponseModel initiateTransfer(@RequestBody Transaction transaction) {
		log.debug("User service " + transaction.getTransferType() +  "receiver account " + transaction.getReceiverAccount());
         System.out.println("@Ramesh mUser service " + transaction.getBeneficiary().getId() +  "receiver account " + transaction.getReceiverAccount());
		RestTemplate resttemplate  = new RestTemplate();
		TransactionResponseModel responsemodel =	resttemplate.postForObject(URL.coordinatorService,transaction,TransactionResponseModel.class );
		System.out.println("start transactin" + responsemodel.getTransaction().getTransactionId());		
		return resttemplate.postForObject(URL.coordinatorService,transaction,TransactionResponseModel.class );
	}
	
}
