package com.uniform.processservice.repository;

import com.uniform.processservice.entity.ClGender;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClGenderRepository extends JpaRepository<ClGender, String> {

}