package com.uniform.legalservice.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DL_ACCOUNT")
@Data
public class DlAccount implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "PROCESS_ID")
    private String processId;
    @Column(name = "ACC_NAME")
    private String accName;
    @Column(name = "ACC_NUMBER")
    private String accNumber;
    @Column(name = "CURRENCY")
    private String currency;
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
    @Column(name = "HIS_CREATED_DATE")
    private Date hisCreatedDate;

}