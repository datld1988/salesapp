package com.salesapp.saleskitservice.repository;

import com.salesapp.saleskitservice.domain.QuestionAndAnswer;
import com.salesapp.saleskitservice.dto.QuestionAndAnswerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionAndAnswerRepository extends JpaRepository<QuestionAndAnswer, Integer> {
    @Query("SELECT new com.salesapp.saleskitservice.dto.QuestionAndAnswerDto(" +
            " qa.id, qa.idSP, qa.ndCauHoi, qa.ndCauTraLoi) " +
            " FROM QuestionAndAnswer qa" +
            " WHERE (lower(qa.ndCauHoi)  LIKE lower(CONCAT ('%',:keyword,'%'))) " +
            " AND (qa.idSP = :idSP)")
    Page<QuestionAndAnswerDto> filterQuestionAndAnswer(
            Pageable page,
            @Param("idSP") Integer idSP,
            @Param("keyword") String keyword
    );



}
