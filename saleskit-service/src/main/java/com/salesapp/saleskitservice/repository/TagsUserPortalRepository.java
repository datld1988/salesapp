package com.salesapp.saleskitservice.repository;

import com.salesapp.saleskitservice.domain.TagsUserPortal;
import com.salesapp.saleskitservice.domain.TagsUserPortalId;
import com.salesapp.saleskitservice.dto.UserPortalDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TagsUserPortalRepository extends JpaRepository<TagsUserPortal, TagsUserPortalId> {

    void deleteTagsUserPortalByIdTag(Integer tagId);

    @Query(" SELECT DISTINCT  tup.tagType FROM  TagsUserPortal  tup WHERE tup.idTag = :tagId AND tup.status = com.salesapp.saleskitservice.constant.TagsConst.StatusActive")
    List<String> getAllTypeOfTag(@Param("tagId") Integer tagId);

    @Query(" SELECT DISTINCT  tup.userPortalId FROM  TagsUserPortal  tup WHERE tup.idTag = :tagId AND tup.status = com.salesapp.saleskitservice.constant.TagsConst.StatusActive")
    List<String> getAllUserAssignTags(@Param("tagId") Integer tagId);

    @Query("SELECT new com.salesapp.saleskitservice.dto.UserPortalDto(tup.userPortalId, aup.fullName)" +
            " FROM TagsUserPortal tup" +
            " JOIN AdUserPortal aup ON tup.userPortalId = aup.userId" +
            " WHERE tup.idTag = :idTag" +
            " AND tup.status = com.salesapp.saleskitservice.constant.TagsConst.StatusActive")
    List<UserPortalDto> getUserByTags(
            @Param("idTag") Integer idTag
    );

    @Query("SELECT tup.tagType" +
            " FROM TagsUserPortal tup" +
            " WHERE tup.idTag = :idTag" +
            " AND tup.status = com.salesapp.saleskitservice.constant.TagsConst.StatusActive")
    List<String> getTypeByTags(
            @Param("idTag") Integer idTag
    );

}
