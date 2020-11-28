package com.salesapp.adminservice.repository;

import com.salesapp.adminservice.domain.AdGroupUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdGroupUserRepository extends JpaRepository<AdGroupUser, String> {

}