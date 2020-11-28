package com.salesapp.authservice.repository;

import com.salesapp.authservice.domain.AdUserApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdUserAppRepository extends JpaRepository<AdUserApp, String> {

}