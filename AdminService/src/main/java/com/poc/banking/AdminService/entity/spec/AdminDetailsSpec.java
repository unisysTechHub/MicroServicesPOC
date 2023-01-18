package com.poc.banking.AdminService.entity.spec;

import org.springframework.data.jpa.domain.Specification;

import com.poc.banking.AdminService.entity.AdminDetails;
import com.poc.banking.AdminService.entity.AdminDetails_;


public class AdminDetailsSpec {
	
	public static Specification<AdminDetails> isValidUser(AdminDetails admin) {
		
		return (root, query, builder ) -> {
			return builder.and(
					builder.equal(root.get(AdminDetails_.USER_ID), admin.getUserId()),
					builder.equal(root.get(AdminDetails_.PASSWORD), admin.getPassword())
					);
		};
	}

	
}
