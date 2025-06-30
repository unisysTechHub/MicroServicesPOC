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
		   // if groups are provding - it only validate fields with groups in Beneficiary model.
		    // rest of the fields not with groups will not be validate - @NotNull validation is not being validated
		    // either all field with @NotNull wihtout groups Or  all feilds with groups works
		    Set<ConstraintViolation<Beneficiary>> violations = validator.validate(beneficiary,groups);

		    if (!violations.isEmpty()) {
		        StringBuilder errorMessage = new StringBuilder();
		        for (ConstraintViolation<Beneficiary> violation : violations) {
		            errorMessage.append(violation.getMessage()).append("; ");
		        }
		         throw new BeneficiaryPropertiesNottFoundException(errorMessage.toString());
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
