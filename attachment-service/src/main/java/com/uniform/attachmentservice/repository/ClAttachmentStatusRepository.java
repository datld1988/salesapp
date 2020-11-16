package com.uniform.attachmentservice.repository;

import com.uniform.attachmentservice.entity.ClAttachmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClAttachmentStatusRepository extends JpaRepository<ClAttachmentStatus, String> {

}