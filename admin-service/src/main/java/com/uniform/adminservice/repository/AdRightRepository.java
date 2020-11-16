package com.uniform.adminservice.repository;

import com.uniform.adminservice.entity.AdRight;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdRightRepository extends JpaRepository<AdRight, String> {

}