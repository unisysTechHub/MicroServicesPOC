package com.poc.banking.AccountService.entity.spec;

import org.springframework.data.jpa.domain.Specification;

import com.poc.banking.AccountService.entity.Account;

public class AccountSpecifications {
    public static Specification<Account> hasAccountId(long l) {
        return (root, query, criteriaBuilder) -> 
            criteriaBuilder.equal(root.get("accountNumber"), l);
    }
    
    public static Specification<Account> hasUserId(String string) {
        return (root, query, criteriaBuilder) -> 
            criteriaBuilder.equal(root.get("userDetails").get("userId"), string);
    }
}
