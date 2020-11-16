package com.uniform.processservice.repository;

import com.uniform.processservice.entity.ClDistrict;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClDistrictRepository extends JpaRepository<ClDistrict, String> {

}