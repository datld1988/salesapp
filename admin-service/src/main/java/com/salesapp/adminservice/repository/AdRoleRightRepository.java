package com.salesapp.adminservice.repository;

import com.salesapp.adminservice.domain.AdRoleRight;
import com.salesapp.adminservice.domain.AdRoleRightId;
import com.salesapp.adminservice.dto.AdRoleMenuDto;
import com.salesapp.adminservice.dto.AdRoleRightDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdRoleRightRepository extends JpaRepository<AdRoleRight, AdRoleRightId> {
    @Modifying
    @Query("DELETE FROM AdRoleRight WHERE roleId = :id ")
    void deleteByRoleKey(@Param("id") String roleId);

    @Query("SELECT new com.salesapp.adminservice.dto.AdRoleRightDto(arr.roleId, arr.rightId) " +
            "FROM AdRoleRight arr" +
            " WHERE arr.roleId = CONCAT('%',:roleID,'%')" +
            " AND arr.rightId =  CONCAT('%',:rightID,'%')")
    AdRoleRightDto findAdRoleRightByRightId(
            @Param("roleID") String roleID,
            @Param("rightID") String rightID
    );
}