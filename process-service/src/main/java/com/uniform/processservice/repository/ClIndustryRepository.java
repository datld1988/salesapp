package com.uniform.processservice.repository;

import com.uniform.processservice.entity.ClIndustry;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClIndustryRepository extends JpaRepository<ClIndustry, String> {

}