package com.poc.banking.AccountService.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.poc.banking.AccountService.entity.Account;

public interface AccountRespository extends  CrudRepository<Account,Long> , JpaSpecificationExecutor<Account>  {
	@Modifying
	@Query("UPDATE Account a SET a.transactionStatus = :newStatus WHERE a.senderAccount = :senderAccount AND a.userDetails.userId = :userId AND a.transactionStatus = 'PREPARED'")
	int updateTransactionStatus(@Param("newStatus") TransactionStatus newStatus,
	                             @Param("senderAccount") String senderAccount,
	                             @Param("userId") Long userId);

}
