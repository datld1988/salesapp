package com.salesapp.customerservice.repository;

import com.salesapp.customerservice.domain.ClProcessStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClProcessStatusRepository extends JpaRepository<ClProcessStatus, String> {

}