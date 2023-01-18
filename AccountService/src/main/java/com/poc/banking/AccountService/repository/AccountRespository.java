package com.poc.banking.AccountService.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.poc.banking.AccountService.entity.Account;

public interface AccountRespository extends CrudRepository<Account,Long> , JpaSpecificationExecutor<Account>  {

}
