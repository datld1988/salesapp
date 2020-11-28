package com.salesapp.authservice.repository;

import com.salesapp.authservice.domain.AdGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdGroupRepository extends JpaRepository<AdGroup, String> {

}