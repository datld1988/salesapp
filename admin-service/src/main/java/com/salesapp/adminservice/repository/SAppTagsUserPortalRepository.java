package com.salesapp.adminservice.repository;

import com.salesapp.adminservice.domain.SAppTagsUserPortal;
import com.salesapp.adminservice.domain.SAppTagsUserPortalId;
import com.salesapp.adminservice.dto.AdRoleRightDto;
import com.salesapp.adminservice.dto.SAppTagsUserPortalDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SAppTagsUserPortalRepository extends JpaRepository<SAppTagsUserPortal, SAppTagsUserPortalId> {
    @Modifying
    @Query("DELETE FROM SAppTagsUserPortal WHERE userPortalId = :id ")
    void deleteByUserId(@Param("id") String userId);

    @Query("SELECT new com.salesapp.adminservice.dto.SAppTagsUserPortalDto(atup.tagId, atup.userPortalId, atup.tagType) " +
            "FROM SAppTagsUserPortal atup" +
            " WHERE atup.userPortalId  = :userPortalId ")
    List<SAppTagsUserPortalDto> findTagsUserPortalByUserId(
            @Param("userPortalId") String userPortalId
    );
}
