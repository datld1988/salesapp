package com.uniform.attachmentservice.repository;

import com.uniform.attachmentservice.domain.DwAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DwAttachmentRepository extends JpaRepository<DwAttachment, String> {

}