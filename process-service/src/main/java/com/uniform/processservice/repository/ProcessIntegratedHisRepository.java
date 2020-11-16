package com.uniform.processservice.repository;

import com.uniform.processservice.entity.ProcessIntegratedHis;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProcessIntegratedHisRepository extends JpaRepository<ProcessIntegratedHis, String> {

}