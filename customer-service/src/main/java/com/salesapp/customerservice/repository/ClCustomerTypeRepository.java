package com.salesapp.customerservice.repository;

import com.salesapp.customerservice.domain.ClCustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClCustomerTypeRepository extends JpaRepository<ClCustomerType, String> {

}