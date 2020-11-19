package com.uniform.legalservice.repository;

import com.uniform.legalservice.domain.DlPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DlPersonRepository extends JpaRepository<DlPerson, String> {

}