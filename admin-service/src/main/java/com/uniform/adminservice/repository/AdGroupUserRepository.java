package com.uniform.adminservice.repository;

import com.uniform.adminservice.domain.AdGroupUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdGroupUserRepository extends JpaRepository<AdGroupUser, String> {

}