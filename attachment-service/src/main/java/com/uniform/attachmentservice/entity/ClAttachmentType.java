package com.uniform.attachmentservice.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CL_ATTACHMENT_TYPE")
@Data
public class ClAttachmentType implements Serializable {

    @Id
    @Column(name = "ID")
    private String Id;
    @Column(name = "NAME")
    private String Name;
    @Column(name = "NAME_F")
    private String NameF;
    @Column(name = "UPLOAD_PRIORITY")
    private Integer UploadPriority;
    @Column(name = "MAX_BYTES")
    private Long MaxBytes;
    @Column(name = "STATUS_CODE")
    private String StatusCode;
    @Column(name = "CREATED_BY")
    private String CreatedBy;
    @Column(name = "CREATED_DATE")
    private Date CreatedDate;
    @Column(name = "MODIFIED_BY")
    private String ModifiedBy;
    @Column(name = "MODIFIED_DATE")
    private Date ModifiedDate;

}