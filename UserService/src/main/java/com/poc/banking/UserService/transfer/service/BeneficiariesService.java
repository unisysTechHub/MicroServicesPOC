package com.poc.banking.UserService.transfer.service;

import java.util.List;

import com.poc.banking.UserService.entity.Beneficiaries;
import com.poc.banking.UserService.entity.UserDetails;
import com.poc.banking.UserService.model.Beneficiary;
import com.poc.banking.UserService.response.BeneficiaryListResponse;
import com.poc.banking.UserService.transfer.response.BeneficiaryResponseModel;

public interface BeneficiariesService {
	public BeneficiaryResponseModel addBeneficiary( Beneficiary beneficiary);
	public BeneficiaryListResponse listBeneficiaries(UserDetails user) ;
}
