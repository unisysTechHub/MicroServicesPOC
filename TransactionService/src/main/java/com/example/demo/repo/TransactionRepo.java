package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Transaction;
import com.example.demo.model.Account;

public interface TransactionRepo extends CrudRepository<Transaction, Long>, JpaSpecificationExecutor<Transaction> {
}

