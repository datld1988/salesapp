package com.salesapp.adminservice.repository;

import com.salesapp.adminservice.domain.AdBranch;
import com.salesapp.adminservice.dto.AdBranchDto;
import com.salesapp.adminservice.dto.AdBranchUserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdBranchRepository extends JpaRepository<AdBranch, String> {
    @Query("SELECT new com.salesapp.adminservice.dto.AdBranchDto(" +
            " ab.id, ab.name, ab.address) " +
            " FROM AdBranch ab" )
    List<AdBranchDto> getBranchList(
    );

}