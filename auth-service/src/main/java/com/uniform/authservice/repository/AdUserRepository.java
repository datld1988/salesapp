package com.uniform.authservice.repository;

import com.uniform.authservice.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdUserRepository extends JpaRepository<AdUser, String> {

}