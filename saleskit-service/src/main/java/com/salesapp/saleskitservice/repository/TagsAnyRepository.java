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
            " ta.idTag, '',ta.idAny, ta.typeAny, '') FROM TagsAny ta" +
            " WHERE lower(ta.idTag)  LIKE lower(CONCAT('%',:idTag,'%'))" +
            " AND lower(ta.idAny)  LIKE lower(CONCAT('%',:idAny,'%'))" +
            " AND lower(ta.typeAny)  LIKE lower(CONCAT('%',:typeAny,'%'))")
    TagsAnyDto checkTags(
            @Param("idTag") Integer idTag,
            @Param("idAny") String idAny,
            @Param("typeAny") String typeAny
    );

    @Query("SELECT new com.salesapp.saleskitservice.dto.TagsAnyDto( " +
            " ta.idTag, t.value , ta.idAny, ta.typeAny," +
            " CASE ta.typeAny " +
                    " WHEN com.salesapp.saleskitservice.constant.TagsConst.TagsNews" +
                        " THEN (SELECT  n.title FROM News n WHERE CONCAT(n.id,'') = ta.idAny)" +
                    " WHEN com.salesapp.saleskitservice.constant.TagsConst.TagsUser" +
                        " THEN (SELECT adu.userName FROM AdUser adu  WHERE CONCAT(adu.id,'') = ta.idAny)"+
                    // TODO : NEU CAN BO SUNG LOAI TAG
                    " ELSE '' " +
            " END" +
            ")" +
            " FROM Tags t JOIN TagsAny ta ON t.id = ta.idTag" +
            " WHERE lower(ta.typeAny)  LIKE lower(CONCAT('%',:typeAny,'%'))")
    List<TagsAnyDto> searchByTypeAny(
            @Param("typeAny") String typeAny
    );

    @Query("SELECT new com.salesapp.saleskitservice.dto.TagsAnyDto( " +
            " ta.idTag, ta.idAny, ta.typeAny, t.value) FROM TagsAny ta" +
            " INNER JOIN News n ON CONCAT(n.id,'')  = ta.idAny" +
            " INNER JOIN Tags t ON t.id = ta.idTag" +
            " WHERE lower(ta.typeAny)  LIKE lower(CONCAT('%',:typeAny,'%'))" +
            " AND n.id= :newsID" +
            " AND ta.status = :status" +
            " AND t.status = :status")
    List<TagsAnyDto> getTagOfNews(
            @Param("typeAny") String typeAny,
            @Param("newsID") Integer newsID,
            @Param("status") Integer status
    );

}
