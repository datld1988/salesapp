package com.uniform.processservice.repository;

import com.uniform.processservice.entity.ClProcessIntegratedType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClProcessIntegratedTypeRepository extends JpaRepository<ClProcessIntegratedType, String> {

}