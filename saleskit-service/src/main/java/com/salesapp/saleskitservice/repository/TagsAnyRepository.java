package com.salesapp.saleskitservice.repository;

import com.salesapp.saleskitservice.domain.TagsAny;
import com.salesapp.saleskitservice.domain.TagsAnyId;
import com.salesapp.saleskitservice.dto.TagsAnyDto;
import com.salesapp.saleskitservice.dto.TagsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TagsAnyRepository extends JpaRepository<TagsAny, String> {
    @Query("SELECT new com.salesapp.saleskitservice.dto.TagsAnyDto( " +
            " ta.idTag, ta.idAny, ta.typeAny) FROM TagsAny ta" +
            " WHERE lower(ta.idTag)  LIKE lower(CONCAT('%',:idTag,'%'))" +
            " AND lower(ta.idAny)  LIKE lower(CONCAT('%',:idAny,'%'))" +
            " AND lower(ta.typeAny)  LIKE lower(CONCAT('%',:typeAny,'%'))")
    TagsAnyDto checkTags(
            @Param("idTag") Integer idTag,
            @Param("idAny") String idAny,
            @Param("typeAny") String typeAny
    );

    @Query("SELECT new com.salesapp.saleskitservice.dto.TagsAnyDto( " +
            " ta.idTag, ta.idAny, ta.typeAny) FROM TagsAny ta" +
            " WHERE lower(ta.typeAny)  LIKE lower(CONCAT('%',:typeAny,'%'))")
    List<TagsAnyDto> searchByTypeAny(
            @Param("typeAny") String typeAny
    );
}
