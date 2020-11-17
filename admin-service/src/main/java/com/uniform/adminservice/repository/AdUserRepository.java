package com.uniform.adminservice.repository;

import com.uniform.adminservice.domain.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdUserRepository extends JpaRepository<AdUser, String> {

}