package com.uniform.authservice.repository;

import com.uniform.authservice.domain.AdGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdGroupRepository extends JpaRepository<AdGroup, String> {

}