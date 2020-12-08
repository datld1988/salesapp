package com.salesapp.adminservice.repository;

import com.salesapp.adminservice.domain.SAppTagsUserPortal;
import com.salesapp.adminservice.domain.SAppTagsUserPortalId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SAppTagsUserPortalRepository extends JpaRepository<SAppTagsUserPortal, SAppTagsUserPortalId> {
    @Modifying
    @Query("DELETE FROM SAppTagsUserPortal WHERE userPortalId = :id ")
    void deleteByUserId(@Param("id") String userId);
}
