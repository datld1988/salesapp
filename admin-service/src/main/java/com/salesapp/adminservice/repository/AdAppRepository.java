package com.salesapp.adminservice.repository;

import com.salesapp.adminservice.domain.AdApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdAppRepository extends JpaRepository<AdApp, String> {

}