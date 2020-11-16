package com.uniform.authservice.repository;

import com.uniform.authservice.entity.AdGroupRole;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdGroupRoleRepository extends JpaRepository<AdGroupRole, String> {

}