package com.uniform.authservice.repository;

import com.uniform.authservice.entity.AdRight;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdRightRepository extends JpaRepository<AdRight, String> {

}