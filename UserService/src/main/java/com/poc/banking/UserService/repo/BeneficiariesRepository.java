package com.poc.banking.UserService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.banking.UserService.entity.Beneficiaries;


@Repository
public interface BeneficiariesRepository extends JpaRepository<Beneficiaries, Long> {
}