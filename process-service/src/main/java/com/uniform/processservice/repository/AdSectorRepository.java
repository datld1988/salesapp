package com.uniform.processservice.repository;

import com.uniform.processservice.entity.AdSector;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdSectorRepository extends JpaRepository<AdSector, String> {

}