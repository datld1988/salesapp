package com.salesapp.customerservice.repository;

import com.salesapp.customerservice.domain.ProcessNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessNotificationRepository extends JpaRepository<ProcessNotification, String> {

}