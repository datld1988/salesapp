package com.salesapp.logservice.repository;

import com.salesapp.logservice.domain.LogEsb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogEsbRepository extends JpaRepository<LogEsb, String> {

}