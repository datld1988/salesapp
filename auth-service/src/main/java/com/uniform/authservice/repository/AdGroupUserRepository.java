package com.uniform.authservice.repository;

import com.uniform.authservice.entity.AdGroupUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdGroupUserRepository extends JpaRepository<AdGroupUser, String> {

}