package com.uniform.processservice.repository;

import com.uniform.processservice.entity.ClPerRelationType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClPerRelationTypeRepository extends JpaRepository<ClPerRelationType, String> {

}