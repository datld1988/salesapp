package com.salesapp.customerservice.repository;

import com.salesapp.customerservice.domain.Process;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessRepository extends JpaRepository<Process, String> {

}