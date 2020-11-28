package com.salesapp.adminservice.repository;

import com.salesapp.adminservice.domain.AdGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdGroupRepository extends JpaRepository<AdGroup, String> {

}