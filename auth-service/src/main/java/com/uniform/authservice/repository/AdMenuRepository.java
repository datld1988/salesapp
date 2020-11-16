package com.uniform.authservice.repository;

import com.uniform.authservice.entity.AdMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdMenuRepository extends JpaRepository<AdMenu, String> {

}