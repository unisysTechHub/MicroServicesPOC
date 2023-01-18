package com.poc.banking.AdminService.entity.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.poc.banking.AdminService.entity.AdminDetails;

public interface AdminRepository extends CrudRepository<AdminDetails,Long>, JpaSpecificationExecutor<AdminDetails>{
	

}
