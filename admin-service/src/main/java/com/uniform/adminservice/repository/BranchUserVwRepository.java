package com.uniform.adminservice.repository;

import com.uniform.adminservice.domain.BranchUserVw;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BranchUserVwRepository extends JpaRepository<BranchUserVw, String> {

}