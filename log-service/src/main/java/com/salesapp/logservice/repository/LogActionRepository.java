package com.salesapp.logservice.repository;

import com.salesapp.logservice.domain.LogAction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogActionRepository extends JpaRepository<LogAction, String> {

}