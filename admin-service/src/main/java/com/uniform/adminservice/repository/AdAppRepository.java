package com.uniform.adminservice.repository;


import com.uniform.adminservice.domain.AdApp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdAppRepository extends JpaRepository<AdApp, String> {
    Optional<AdApp> findByClientId(String clientId);
}