package com.uniform.authservice.repository;

import com.uniform.authservice.entity.AdUserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdUserAppRepository extends JpaRepository<AdUserApp, String> {

}