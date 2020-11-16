package com.uniform.adminservice.repository;

import com.uniform.adminservice.entity.AdRole;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdRoleRepository extends JpaRepository<AdRole, String> {

}