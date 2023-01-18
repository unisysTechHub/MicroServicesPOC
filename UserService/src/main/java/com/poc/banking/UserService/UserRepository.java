package com.poc.banking.UserService;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<UserDetails, String>, JpaSpecificationExecutor<UserDetails>
{

}
