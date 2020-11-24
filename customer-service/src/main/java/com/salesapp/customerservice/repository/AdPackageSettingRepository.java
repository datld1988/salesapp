package com.salesapp.customerservice.repository;

import com.salesapp.customerservice.domain.AdPackageSetting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdPackageSettingRepository extends JpaRepository<AdPackageSetting, String> {

}