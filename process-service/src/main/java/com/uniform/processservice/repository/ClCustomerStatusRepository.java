package com.uniform.processservice.repository;

import com.uniform.processservice.entity.ClCustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClCustomerStatusRepository extends JpaRepository<ClCustomerStatus, String> {

}