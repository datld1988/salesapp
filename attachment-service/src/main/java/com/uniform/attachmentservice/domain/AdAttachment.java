package com.uniform.attachmentservice.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "AD_ATTACHMENT")
@Data
public class AdAttachment implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "INTEGRATED_TYPE")
    private String integratedType;
    @Column(name = "ATTACHED_TYPE_ID")
    private String attachedTypeId;
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