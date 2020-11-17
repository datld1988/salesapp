package com.uniform.processservice.repository;

import com.uniform.processservice.domain.ProcessNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessNotificationRepository extends JpaRepository<ProcessNotification, String> {

}