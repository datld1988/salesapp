package com.uniform.adminservice.repository;

import com.uniform.adminservice.domain.UserBranchVw;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserBranchVwRepository extends JpaRepository<UserBranchVw, String> {

}