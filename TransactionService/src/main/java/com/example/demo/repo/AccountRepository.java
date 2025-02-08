package com.example.demo.repo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, String>, JpaSpecificationExecutor<Account> {

}
