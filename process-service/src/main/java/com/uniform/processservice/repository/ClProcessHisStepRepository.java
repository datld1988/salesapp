package com.uniform.processservice.repository;

import com.uniform.processservice.entity.ClProcessHisStep;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClProcessHisStepRepository extends JpaRepository<ClProcessHisStep, String> {

}