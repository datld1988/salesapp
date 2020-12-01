package com.salesapp.customerservice.repository;

import com.salesapp.customerservice.domain.DwPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DwPersonRepository extends JpaRepository<DwPerson, String> {

}