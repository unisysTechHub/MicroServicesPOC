package com.poc.banking.UserService.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.poc.banking.UserService.entity.Beneficiaries;
import com.poc.banking.UserService.entity.UserDetails;

import java.util.List;

@Repository
public class UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Beneficiaries> findBeneficiaryByBankname(String bankName) {
        String hql = "FROM Beneficiaries u WHERE u.BankName = :bankName";
        return entityManager.createQuery(hql, Beneficiaries.class)
        		.setParameter("bankName",bankName)
                .getResultList();
    }

   
}
