package com.uniform.adminservice.repository;

import com.uniform.adminservice.entity.AdBranchRm;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdBranchRmRepository extends JpaRepository<AdBranchRm, String> {

}