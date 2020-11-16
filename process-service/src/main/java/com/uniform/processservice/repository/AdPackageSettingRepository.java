package com.uniform.processservice.repository;

import com.uniform.processservice.entity.AdPackageSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdPackageSettingRepository extends JpaRepository<AdPackageSetting, String> {

}