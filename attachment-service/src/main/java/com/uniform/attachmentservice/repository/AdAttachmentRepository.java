package com.uniform.attachmentservice.repository;

import com.uniform.attachmentservice.entity.AdAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdAttachmentRepository extends JpaRepository<AdAttachment, String> {

}