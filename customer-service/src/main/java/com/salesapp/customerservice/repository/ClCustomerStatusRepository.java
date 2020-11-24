package com.salesapp.customerservice.repository;

import com.salesapp.customerservice.domain.ClCustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClCustomerStatusRepository extends JpaRepository<ClCustomerStatus, String> {

}