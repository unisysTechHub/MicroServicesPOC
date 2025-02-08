package com.poc.banking.UserService.transfercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.poc.banking.UserService.entity.Beneficiaries;
import com.poc.banking.UserService.entity.UserDetails;
import com.poc.banking.UserService.model.Beneficiary;
import com.poc.banking.UserService.repo.UserRepositoryCustom;
import com.poc.banking.UserService.response.BeneficiaryListResponse;
import com.poc.banking.UserService.transfer.response.BeneficiaryResponseModel;
import com.poc.banking.UserService.transfer.service.BeneficiariesService;

@RestController
@RequestMapping(value = "/api/transfer")

public class MainTransferController {

	@Autowired
	BeneficiariesService beneficiariesService;
	@Autowired
	UserRepositoryCustom userRepositoryCustom;
	
	@RequestMapping(value = "/addBeneficiary", method = RequestMethod.POST,consumes = "application/json" )
	@ResponseBody
	BeneficiaryResponseModel addBeneficiary(@RequestBody Beneficiary beneficiary) {
		
		System.out.println("@Rameseh controller " + beneficiary.getUserId());
		return beneficiariesService.addBeneficiary(beneficiary);
		
	}
	
	@RequestMapping(value = "/beneficiaries", method = RequestMethod.POST,consumes = "application/json" )
	@ResponseBody
	BeneficiaryListResponse beneficiaryList(@RequestBody UserDetails userDetails) {
		Beneficiaries  b = userRepositoryCustom.findBeneficiaryByBankname("ABC Bank").get(0);
		System.out.println("@Ramesh" + b.getAccountNumber());
		System.out.println("@Rameseh controller " + userDetails.getUserId());
		return beneficiariesService.listBeneficiaries(userDetails);
		
	}
	
}
