package com.uniform.authservice.repository;

import com.uniform.authservice.domain.AdGroupUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdGroupUserRepository extends JpaRepository<AdGroupUser, String> {

}