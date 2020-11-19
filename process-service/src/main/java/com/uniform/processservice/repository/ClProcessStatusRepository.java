package com.uniform.processservice.repository;

import com.uniform.processservice.domain.ClProcessStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClProcessStatusRepository extends JpaRepository<ClProcessStatus, String> {

}