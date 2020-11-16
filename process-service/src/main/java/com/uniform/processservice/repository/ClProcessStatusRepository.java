package com.uniform.processservice.repository;

import com.uniform.processservice.entity.ClProcessStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClProcessStatusRepository extends JpaRepository<ClProcessStatus, String> {

}