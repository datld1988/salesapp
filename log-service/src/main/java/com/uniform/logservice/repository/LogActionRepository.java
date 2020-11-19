package com.uniform.logservice.repository;

import com.uniform.logservice.domain.LogAction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogActionRepository extends JpaRepository<LogAction, String> {

}