package com.uniform.cardservice.repository;

import com.uniform.cardservice.domain.DwCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DwCardRepository extends JpaRepository<DwCard, String> {

}