package com.salesapp.customerservice.repository;

import com.salesapp.customerservice.domain.ClStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClStatusRepository extends JpaRepository<ClStatus, String> {

}