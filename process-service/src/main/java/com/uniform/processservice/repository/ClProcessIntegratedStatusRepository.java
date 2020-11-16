package com.uniform.processservice.repository;

import com.uniform.processservice.entity.ClProcessIntegratedStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClProcessIntegratedStatusRepository extends JpaRepository<ClProcessIntegratedStatus, String> {

}