package com.uniform.adminservice.repository;

import com.uniform.adminservice.entity.AdUserBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdUserBranchRepository extends JpaRepository<AdUserBranch, String> {

}