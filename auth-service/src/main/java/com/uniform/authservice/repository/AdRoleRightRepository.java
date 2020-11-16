package com.uniform.authservice.repository;

import com.uniform.authservice.entity.AdRoleRight;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdRoleRightRepository extends JpaRepository<AdRoleRight, String> {

}