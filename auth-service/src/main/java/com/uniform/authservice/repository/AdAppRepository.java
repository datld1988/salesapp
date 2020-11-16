package com.uniform.authservice.repository;

import com.uniform.authservice.entity.AdApp;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdAppRepository extends JpaRepository<AdApp, String> {

}