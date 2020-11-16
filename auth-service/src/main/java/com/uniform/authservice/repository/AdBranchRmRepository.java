package com.uniform.authservice.repository;

import com.uniform.authservice.entity.AdBranchRm;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdBranchRmRepository extends JpaRepository<AdBranchRm, String> {

}