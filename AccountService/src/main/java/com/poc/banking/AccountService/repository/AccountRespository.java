package com.poc.banking.AccountService.repository;

import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poc.banking.AccountService.entity.Account;

@Repository
public interface AccountRespository extends  CrudRepository<Account,Long> , JpaSpecificationExecutor<Account>  {
	

}
