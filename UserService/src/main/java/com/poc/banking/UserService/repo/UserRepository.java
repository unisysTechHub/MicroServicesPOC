package com.poc.banking.UserService.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.poc.banking.UserService.entity.UserDetails;

public interface UserRepository  extends CrudRepository<UserDetails, String>, JpaSpecificationExecutor<UserDetails>
{
	 Optional<UserDetails> findByUserId(String userId);
}
