package com.salesapp.customerservice.repository;

import com.salesapp.customerservice.domain.DwCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DwCustomerRepository extends JpaRepository<DwCustomer, String> {

}