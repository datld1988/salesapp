package com.uniform.adminservice.repository;

import com.uniform.adminservice.domain.AdGroupRole;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdGroupRoleRepository extends JpaRepository<AdGroupRole, String> {

}