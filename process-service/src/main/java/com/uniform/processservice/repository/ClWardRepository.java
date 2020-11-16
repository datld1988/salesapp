package com.uniform.processservice.repository;

import com.uniform.processservice.entity.ClWard;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClWardRepository extends JpaRepository<ClWard, String> {

}