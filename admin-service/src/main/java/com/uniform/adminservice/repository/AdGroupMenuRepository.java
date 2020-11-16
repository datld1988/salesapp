package com.uniform.adminservice.repository;

import com.uniform.adminservice.entity.AdGroupMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdGroupMenuRepository extends JpaRepository<AdGroupMenu, String> {

}