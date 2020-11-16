package com.uniform.processservice.repository;

import com.uniform.processservice.entity.ProcessHis;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProcessHisRepository extends JpaRepository<ProcessHis, String> {

}