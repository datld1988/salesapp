package com.uniform.legalservice.repository;

import com.uniform.legalservice.domain.Process;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessRepository extends JpaRepository<Process, String> {

}