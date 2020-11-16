package com.uniform.authservice.repository;

import com.uniform.authservice.entity.AdBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdBranchRepository extends JpaRepository<AdBranch, String> {

}