package com.uniform.processservice.repository;

import com.uniform.processservice.entity.ClCustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClCustomerTypeRepository extends JpaRepository<ClCustomerType, String> {

}