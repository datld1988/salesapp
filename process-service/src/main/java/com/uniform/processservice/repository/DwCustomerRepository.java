package com.uniform.processservice.repository;

import com.uniform.processservice.entity.DwCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DwCustomerRepository extends JpaRepository<DwCustomer, String> {

}