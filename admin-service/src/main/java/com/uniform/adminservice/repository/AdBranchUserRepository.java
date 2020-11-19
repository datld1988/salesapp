package com.uniform.adminservice.repository;

import com.uniform.adminservice.domain.AdBranchUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdBranchUserRepository extends JpaRepository<AdBranchUser, String> {

}