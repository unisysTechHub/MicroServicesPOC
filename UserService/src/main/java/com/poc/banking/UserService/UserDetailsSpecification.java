package com.poc.banking.UserService;

import java.util.function.Function;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.FluentQuery;

import com.poc.banking.UserService.entity.UserDetails;
import com.poc.banking.UserService.entity.UserDetails_;

import jakarta.persistence.criteria.CriteriaQuery;

public class UserDetailsSpecification {
	 
	public static Specification<UserDetails> isValidCredentials( UserDetails user) {
	    return (root, query, builder) -> {
	     // LocalDate date = LocalDate.now().minusYears(2);
	   // CriteriaQuery<UserDetails> q =	builder.createQuery(UserDetails.class);
	    	query.distinct(false);
	      return builder.and(builder.equal(root.get(UserDetails_.USER_ID), user.getUserId()),builder.equal(root.get(UserDetails_.PASSWORD), user.getPassword()));
	    };
	  }
	
	public static Specification<UserDetails> isValidUser( UserDetails user) {
	    return (root, query, builder) -> {
	      return builder.equal(root.get(UserDetails_.USER_ID), user.getUserId());
	    };
	  }
	
 public static Specification<UserDetails> fetchUserDetails(UserDetails user) {
		
		return (root, query, builder ) -> {
			return builder.and(
					builder.equal(root.get(UserDetails_.USER_ID), user.getUserId()),
					builder.equal(root.get(UserDetails_.PASSWORD), user.getPassword())
					);
		};
	}
}
