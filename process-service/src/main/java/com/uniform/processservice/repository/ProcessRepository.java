package com.uniform.processservice.repository;

import com.uniform.processservice.entity.Process;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProcessRepository extends JpaRepository<Process, String> {

}