package com.uniform.adminservice.repository;

import com.uniform.adminservice.domain.AdRoleRight;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdRoleRightRepository extends JpaRepository<AdRoleRight, String> {

}