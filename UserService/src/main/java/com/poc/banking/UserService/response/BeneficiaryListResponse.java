package com.poc.banking.UserService.response;

import java.util.List;

import com.poc.banking.UserService.entity.Beneficiaries;
import com.poc.banking.UserService.model.Beneficiary;
import com.poc.banking.UserService.transfer.response.BeneficiaryModel;

public class BeneficiaryListResponse extends BaseResponse {
    List<BeneficiaryModel> beneficiarylist;
    public BeneficiaryListResponse() {
    	super();
    }
	public BeneficiaryListResponse(String message, String responseCode) {
		
		super(message,responseCode);
	}
	public List<BeneficiaryModel> getBeneficiarylist() {
		return beneficiarylist;
	}
	public void setBeneficiarylist(List<BeneficiaryModel> beneficiarylist) {
		this.beneficiarylist = beneficiarylist;
	}
	

	
    
}
