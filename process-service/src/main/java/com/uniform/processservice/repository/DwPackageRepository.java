package com.uniform.processservice.repository;

import com.uniform.processservice.entity.DwPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DwPackageRepository extends JpaRepository<DwPackage, String> {

}