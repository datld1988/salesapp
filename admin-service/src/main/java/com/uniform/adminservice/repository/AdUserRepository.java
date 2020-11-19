package com.uniform.adminservice.repository;

import com.uniform.adminservice.domain.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdUserRepository extends JpaRepository<AdUser, String> {

}