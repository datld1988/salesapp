package com.uniform.processservice.repository;

import com.uniform.processservice.entity.ClCity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClCityRepository extends JpaRepository<ClCity, String> {

}