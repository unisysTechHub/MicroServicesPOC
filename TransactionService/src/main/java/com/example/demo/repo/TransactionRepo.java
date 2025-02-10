package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Transaction;
import com.example.demo.model.Account;
import com.example.demo.model.TransactionStatus;

import io.lettuce.core.dynamic.annotation.Param;

public interface TransactionRepo extends CrudRepository<Transaction, Long>, JpaSpecificationExecutor<Transaction> {
	@Modifying
	@Query("UPDATE Transaction t SET t.status = :status WHERE t.id = :id")
	int updateTransactionStatus(@Param("id") Long id, @Param("status") TransactionStatus status);

}

