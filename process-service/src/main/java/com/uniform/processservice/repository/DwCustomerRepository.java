package com.uniform.processservice.repository;

import com.uniform.processservice.domain.DwCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DwCustomerRepository extends JpaRepository<DwCustomer, String> {

}