package com.uniform.adminservice.repository;

import com.uniform.adminservice.domain.AdBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdBranchRepository extends JpaRepository<AdBranch, String> {

}