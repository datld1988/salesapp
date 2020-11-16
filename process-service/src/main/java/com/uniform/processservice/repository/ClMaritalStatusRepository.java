package com.uniform.processservice.repository;

import com.uniform.processservice.entity.ClMaritalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClMaritalStatusRepository extends JpaRepository<ClMaritalStatus, String> {

}