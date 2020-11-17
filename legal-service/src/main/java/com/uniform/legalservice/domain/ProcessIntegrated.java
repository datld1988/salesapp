package com.uniform.legalservice.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PROCESS_INTEGRATED")
@Data
public class ProcessIntegrated implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "PROCESS_ID")
    private String processId;
    @Column(name = "STATUS_ID")
    private String statusId;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "OBJECT_ID")
    private String objectId;
    @Column(name = "APPROVE_PRIORITY")
    private Integer approvePriority;
    @Column(name = "ACTION")
    private String action;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "REQUEST_ID")
    private String requestId;
    @Column(name = "SENT_DATE")
    private Date sentDate;
    @Column(name = "RECEIVE_DATE")
    private Date receiveDate;
    @Column(name = "RECEIVE_DATA")
    private String receiveData;
    @Column(name = "RE_TRY")
    private Integer reTry;
    @Column(name = "APPROVE_DATE")
    private Date approveDate;
    @Column(name = "APPROVE_BY")
    private String approveBy;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;
    @Column(name = "HIS_CREATED_DATE")
    private Date hisCreatedDate;

}