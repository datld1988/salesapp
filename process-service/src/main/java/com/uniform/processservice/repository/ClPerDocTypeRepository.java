package com.uniform.processservice.repository;

import com.uniform.processservice.entity.ClPerDocType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClPerDocTypeRepository extends JpaRepository<ClPerDocType, String> {

}