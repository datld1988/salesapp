package com.uniform.processservice.repository;

import com.uniform.processservice.entity.ClService;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClServiceRepository extends JpaRepository<ClService, String> {

}