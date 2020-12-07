package com.salesapp.saleskitservice.repository;

import com.salesapp.saleskitservice.domain.News;
import com.salesapp.saleskitservice.dto.NewsTagDto;
import com.salesapp.saleskitservice.dto.TagsDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {

    @Query("SELECT new com.salesapp.saleskitservice.dto.NewsTagDto(" +
            " n.id, n.title, n.image, n.priority)" +
            " FROM News n" +
            " LEFT JOIN TagsAny ta ON CONCAT(n.id, '') = ta.idAny" +
            " JOIN Tags t ON ta.idTag = t.id" +
            " WHERE (n.priority = :priority OR :priority IS NULL)" +
            " AND (n.pubDate >= :fromDate OR :fromDate IS NULL)" +
            " AND (n.pubDate <= :toDate OR :toDate IS NULL)" +
            " AND (t.value IN :tagList OR :tagList IS NULL)" +
            " AND n.status = :status" +
            " ORDER BY n.createDate DESC")
    List<NewsTagDto> searchNews(
            Pageable page,
            @Param("priority") String priority,
            @Param("fromDate") Date fromDate,
            @Param("toDate") Date toDate,
            @Param("status") Integer status,
            @Param("tagList") List<String> tagList);

    @Query("SELECT new com.salesapp.saleskitservice.dto.TagsDto(" +
            "t.id, t.value, t.status) " +
            "FROM Tags t" +
            " JOIN TagsAny ta ON t.id = ta.idTag" +
            " WHERE ta.idAny = :newsId" +
            " AND t.status = :status" +
            " AND ta.typeAny = :tagNews")
    List<TagsDto> getTagsOfNews(
            @Param("newsId") String newsId,
            @Param("status") Integer status,
            @Param("tagNews") String tagNews
    );
}
