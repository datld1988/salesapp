package com.salesapp.adminservice.repository;

import com.salesapp.adminservice.domain.AdBranchUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdBranchUserRepository extends JpaRepository<AdBranchUser, String> {

}