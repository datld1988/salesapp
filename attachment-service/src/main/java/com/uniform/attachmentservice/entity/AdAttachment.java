package com.uniform.attachmentservice.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "AD_ATTACHMENT")
@Data
public class AdAttachment implements Serializable {

    @Id
    @Column(name = "ID")
    private String Id;
    @Column(name = "INTEGRATED_TYPE")
    private String IntegratedType;
    @Column(name = "ATTACHED_TYPE_ID")
    private String AttachedTypeId;
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