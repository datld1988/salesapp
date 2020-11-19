package com.uniform.attachmentservice.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DW_ATTACHMENT")
@Data
public class DwAttachment implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "PROCESS_ID")
    private String processId;
    @Column(name = "INTEGRATED_ID")
    private String integratedId;
    @Column(name = "BIN_ID")
    private String binId;
    @Column(name = "ATTACHMENT_TYPE")
    private String attachmentType;
    @Column(name = "STATUS_ID")
    private String statusId;
    @Column(name = "INTEGRATED_TYPE")
    private String integratedType;
    @Column(name = "OBJECT_ID")
    private String objectId;
    @Column(name = "APPROVE_PRIORITY")
    private Integer approvePriority;
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
    @Column(name = "RM_PRIMARY_CODE")
    private String rmPrimaryCode;
    @Column(name = "RM_SECONDARY_CODE")
    private String rmSecondaryCode;
    @Column(name = "BRANCH_CODE")
    private String branchCode;
    @Column(name = "CURRENT_STATE")
    private String currentState;
    @Column(name = "CHANGE_STATE")
    private String changeState;
    @Column(name = "ACTION")
    private String action;
    @Column(name = "REQUEST_ID")
    private String requestId;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

}