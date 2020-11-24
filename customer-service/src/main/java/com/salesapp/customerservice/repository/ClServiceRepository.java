package com.salesapp.customerservice.repository;

import com.salesapp.customerservice.domain.ClService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClServiceRepository extends JpaRepository<ClService, String> {

}