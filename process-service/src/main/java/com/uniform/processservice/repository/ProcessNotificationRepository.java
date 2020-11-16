package com.uniform.processservice.repository;

import com.uniform.processservice.entity.ProcessNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProcessNotificationRepository extends JpaRepository<ProcessNotification, String> {

}