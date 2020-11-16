package com.uniform.processservice.repository;

import com.uniform.processservice.entity.ClPerRelationSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClPerRelationSubjectRepository extends JpaRepository<ClPerRelationSubject, String> {

}