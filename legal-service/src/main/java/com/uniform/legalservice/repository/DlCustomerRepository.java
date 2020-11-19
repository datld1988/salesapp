package com.uniform.legalservice.repository;

import com.uniform.legalservice.domain.DlCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DlCustomerRepository extends JpaRepository<DlCustomer, String> {

}