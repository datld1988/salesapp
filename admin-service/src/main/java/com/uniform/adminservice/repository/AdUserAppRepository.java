package com.uniform.adminservice.repository;

import com.uniform.adminservice.domain.AdUserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdUserAppRepository extends JpaRepository<AdUserApp, String> {

}