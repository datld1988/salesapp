package com.salesapp.saleskitservice.repository;

import com.salesapp.saleskitservice.domain.QuestionAndAnswer;
import com.salesapp.saleskitservice.domain.Tags;
import com.salesapp.saleskitservice.dto.PromotionDto;
import com.salesapp.saleskitservice.dto.TagsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepository extends JpaRepository<Tags, Integer> {
    @Query("SELECT new com.salesapp.saleskitservice.dto.TagsDto( " +
            " t.id, t.value) FROM Tags t" +
            " WHERE lower(t.value)  LIKE lower(CONCAT('%',:value,'%'))")
    TagsDto checkTags(
            @Param("value") String value
    );
}
