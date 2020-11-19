package com.uniform.adminservice.repository;

import com.uniform.adminservice.domain.AdGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdGroupRepository extends JpaRepository<AdGroup, String> {

}