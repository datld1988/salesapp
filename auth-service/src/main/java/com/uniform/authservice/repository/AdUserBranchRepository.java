package com.uniform.authservice.repository;

import com.uniform.authservice.entity.AdUserBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdUserBranchRepository extends JpaRepository<AdUserBranch, String> {

}