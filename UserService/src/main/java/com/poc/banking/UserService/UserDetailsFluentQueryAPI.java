package com.poc.banking.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import com.poc.banking.UserService.entity.UserDetails;
import com.poc.banking.UserService.repo.UserRepository;
import com.poc.banking.UserService.response.LoginResponse;

@Repository
public class UserDetailsFluentQueryAPI {

	@Autowired
	UserRepository userRepo;
	
	public boolean isValidCredentials(UserDetails userDetails) {
		
		return 	 userRepo.findBy(UserDetailsSpecification.isValidCredentials(userDetails), 
				q -> { 
					//UserDetalisFluentQuery query = (UserDetalisFluentQuery) this.query(q); 
				
					return (this.query(q).exists() ); }
				);
	}
   public UserDetails isValidUser(UserDetails userDetails) {
		
		return userRepo.findBy(UserDetailsSpecification.isValidUser(userDetails), 
				                                  q -> {
				                                	  FetchableFluentQuery query = this.query((FetchableFluentQuery<UserDetails>) q);
				                                	 
				                                	  return this.query(q).firstValue();});
	}
   
   public UserDetails fetchUserDetilas(UserDetails userDetails) {
		
		return userRepo.findBy(UserDetailsSpecification.isValidUser(userDetails), 
				                                  q -> {
				                                	  FetchableFluentQuery query = this.query((FetchableFluentQuery<UserDetails>) q);
				                                	 
				                                	  return this.query(q).firstValue();});
	}
  
   
   
//   List<Account> fetchAccounts(UserDetails userDetails) {
//		
//		return userRepo.findBy(UserDetailsSpecification.fetchUserDetails(userDetails), 
//				                                  q -> {
//				                                	  FetchableFluentQuery query = this.query((FetchableFluentQuery<UserDetails>) q);
//				                                	 
//				                                	  return query(q).firstValue().getAccountList();});
//	}
//	 FluentQuery.FetchableFluentQuery<UserDetails>  query( FluentQuery.FetchableFluentQuery<UserDetails>  q) {
//		return new UserDetalisFluentQuery(q) ;
//	}
	
	 FluentQuery.FetchableFluentQuery<UserDetails>  query( FluentQuery.FetchableFluentQuery<UserDetails>  q) {
		return new EntityFluentQuery<UserDetails>(q) ;
	}
}
