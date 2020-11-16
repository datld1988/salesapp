package com.uniform.authservice.repository;

import com.uniform.authservice.entity.AdRm;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdRmRepository extends JpaRepository<AdRm, String> {

}