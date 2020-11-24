package com.salesapp.adminservice.repository;

import com.salesapp.adminservice.domain.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdUserRepository extends JpaRepository<AdUser, String> {

}