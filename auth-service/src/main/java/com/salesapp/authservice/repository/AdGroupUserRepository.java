package com.salesapp.authservice.repository;

import com.salesapp.authservice.domain.AdGroupUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdGroupUserRepository extends JpaRepository<AdGroupUser, String> {

}