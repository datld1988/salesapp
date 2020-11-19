package com.uniform.processservice.repository;

import com.uniform.processservice.domain.DwPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DwPersonRepository extends JpaRepository<DwPerson, String> {

}