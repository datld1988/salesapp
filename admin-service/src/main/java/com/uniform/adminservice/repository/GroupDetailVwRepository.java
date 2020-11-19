package com.uniform.adminservice.repository;

import com.uniform.adminservice.domain.GroupDetailVw;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface GroupDetailVwRepository extends JpaRepository<GroupDetailVw, String> {

}