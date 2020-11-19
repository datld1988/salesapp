package com.uniform.attachmentservice.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CL_ATTACHMENT_TYPE")
@Data
public class ClAttachmentType implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "NAME_F")
    private String nameF;
    @Column(name = "UPLOAD_PRIORITY")
    private Integer uploadPriority;
    @Column(name = "MAX_BYTES")
    private Long maxBytes;
    @Column(name = "STATUS_CODE")
    private String statusCode;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

}