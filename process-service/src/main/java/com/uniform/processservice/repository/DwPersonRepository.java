package com.uniform.processservice.repository;

import com.uniform.processservice.entity.DwPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DwPersonRepository extends JpaRepository<DwPerson, String> {

}