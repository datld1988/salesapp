package com.uniform.attachmentservice.repository;

import com.uniform.attachmentservice.domain.AdAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdAttachmentRepository extends JpaRepository<AdAttachment, String> {

}