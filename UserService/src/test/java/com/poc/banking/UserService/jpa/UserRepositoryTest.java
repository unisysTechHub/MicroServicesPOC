package com.poc.banking.UserService.jpa;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import com.banking.auth.entity.User;
import com.banking.auth.repo.UsersRepository;

@DataJpaTest
public class UserRepositoryTest {
	@Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UsersRepository userRepo;
    
    @Test
    void testFindbyName() {
    	User user = new User();
    	user.setUsername("Ramesh");
    	user.setPassword("password");
    	entityManager.persist(user);
    	Optional<User> found = userRepo.findByUsername("Ramesh");
    	assertTrue(found.isPresent());
    			
    }


}
