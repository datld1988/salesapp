package com.uniform.adminservice.repository;

import com.uniform.adminservice.domain.AdMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdMenuRepository extends JpaRepository<AdMenu, String> {

}