package com.salesapp.saleskitservice.repository;

import com.salesapp.saleskitservice.domain.TagsUserPortal;
import com.salesapp.saleskitservice.domain.TagsUserPortalId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TagsUserPortalRepository extends JpaRepository<TagsUserPortal, TagsUserPortalId> {

    void deleteTagsUserPortalByIdTag(Integer tagId);

}
