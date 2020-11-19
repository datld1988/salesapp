package com.uniform.adminservice.repository;

import com.uniform.adminservice.domain.RoleDetailVw;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleDetailVwRepository extends JpaRepository<RoleDetailVw, String> {

}