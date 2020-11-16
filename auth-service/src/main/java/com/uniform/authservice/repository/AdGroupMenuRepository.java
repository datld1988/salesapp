package com.uniform.authservice.repository;

import com.uniform.authservice.entity.AdGroupMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdGroupMenuRepository extends JpaRepository<AdGroupMenu, String> {

}