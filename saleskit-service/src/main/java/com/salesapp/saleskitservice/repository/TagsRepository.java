package com.salesapp.saleskitservice.repository;

import com.salesapp.saleskitservice.domain.QuestionAndAnswer;
import com.salesapp.saleskitservice.domain.Tags;
import com.salesapp.saleskitservice.domain.TagsUserPortal;
import com.salesapp.saleskitservice.dto.PromotionDto;
import com.salesapp.saleskitservice.dto.TagsDto;
import com.salesapp.saleskitservice.dto.TagsUserPortalDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagsRepository extends JpaRepository<Tags, Integer> {
    @Query("SELECT new com.salesapp.saleskitservice.dto.TagsDto( " +
            " t.id, t.value) FROM Tags t" +
            " WHERE lower(t.value)  LIKE lower(CONCAT('%',:value,'%'))")
    TagsDto checkTags(
            @Param("value") String value
    );
    @Query("SELECT DISTINCT new com.salesapp.saleskitservice.dto.TagsDto( " +
            " t.id, t.value) " +
            "FROM Tags t "   +
            "INNER JOIN TagsUserPortal tup ON t.id = tup.idTag "+
            "WHERE t.status = com.salesapp.saleskitservice.constant.TagsConst.StatusActive "+
            "AND tup.tagType = com.salesapp.saleskitservice.constant.TagsConst.TagsNews"
    )
    List<TagsDto> getAllTagForTypeNew(
    );

    Tags getTagsByIdAndStatus(Integer id, Integer status);

    @Query("SELECT new com.salesapp.saleskitservice.dto.TagsUserPortalDto(" +
                "t.id, t.value, t.keyTag " +
//                "(SELECT tup.tagType FROM TagsUserPortal tup WHERE tup.idTag = t.id), " +
//                "(SELECT up.fullName FROM AdUserPortal up INNER JOIN TagsUserPortal tup ON tup.userPortalId = up.userId WHERE  tup.idTag = t.id AND up.status = 1 AND tup.status = 1) " +
            ")" +
            "FROM Tags t " +
            "WHERE t.status = com.salesapp.saleskitservice.constant.TagsConst.StatusActive"

    )
    List<TagsUserPortalDto> getAllTags();

    Tags getTagsById(Integer tagId);

    @Query("SELECT new com.salesapp.saleskitservice.dto.TagsUserPortalDto(" +
            " t.id, t.value, t.keyTag)" +
            " FROM Tags t" +
            " WHERE t.status = com.salesapp.saleskitservice.constant.TagsConst.StatusActive" +
            " AND (t.value LIKE CONCAT('%', :valueSearch, '%') OR :valueSearch IS NULL)")
    Page<TagsUserPortalDto> searchTags(
            Pageable pageable,
            @Param("valueSearch") String valueSearch
    );
}
