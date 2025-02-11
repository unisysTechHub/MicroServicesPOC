package com.poc.banking.UserService.transfer.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.poc.banking.UserService.entity.Beneficiaries;
import com.poc.banking.UserService.model.Beneficiary;
import com.poc.banking.UserService.transfer.response.BeneficiaryModel;
import com.poc.banking.UserService.transfer.response.BeneficiaryResponseModel;

@Mapper
public interface BeneficiaryMapper {
    BeneficiaryMapper INSTANCE = Mappers.getMapper(BeneficiaryMapper.class);

    @Mapping(target = "userDetails", ignore = true)  // Handle associations manually if needed
    Beneficiaries toBeneficiaries(Beneficiary beneficiary);

    BeneficiaryModel toBeneficiary(Beneficiaries beneficiary);

}