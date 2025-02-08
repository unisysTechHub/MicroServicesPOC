package com.poc.banking.UserService.transfer.service;

import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.poc.banking.UserService.entity.Beneficiaries;
import com.poc.banking.UserService.model.Beneficiary;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@Component
public class BeneficiariesValidtionService {
	 private final Log log = LogFactory.getLog(getClass());
	public void validateBeneficiary(Beneficiary beneficiary,Class<?>... groups) throws IllegalArgumentException  {
		log.debug(getClass().getSimpleName() + " validateBeneficiary");
		 ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		    Validator validator = factory.getValidator();
		    Set<ConstraintViolation<Beneficiary>> violations = validator.validate(beneficiary,groups);

		    if (!violations.isEmpty()) {
		        StringBuilder errorMessage = new StringBuilder();
		        for (ConstraintViolation<Beneficiary> violation : violations) {
		            errorMessage.append(violation.getMessage()).append("; ");
		        }
		        throw new IllegalArgumentException(errorMessage.toString());
		    }
		    
		    log.debug("Beneficiary validatin  successfull");
		    	    
	}
	
	Beneficiaries addDomesticBeneficiary(Beneficiary beneficiary) throws Exception {
		try {
		  return  BeneficiaryMapper.INSTANCE.toBeneficiaries(beneficiary);
		 }catch(Exception e) {
			 throw e;
		 }
 	 }
}
