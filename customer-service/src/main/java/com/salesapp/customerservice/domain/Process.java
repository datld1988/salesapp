package com.salesapp.customerservice.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PROCESS")
@Data
public class Process implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "CODE")
    private String code;
    @Column(name = "STATUS_ID")
    private String statusId;
    @Column(name = "BRANCH_CODE")
    private String branchCode;
    @Column(name = "INPUT_DATE")
    private Date inputDate;
    @Column(name = "INPUT_BY")
    private String inputBy;
    @Column(name = "APPROVE_DATE")
    private Date approveDate;
    @Column(name = "APPROVE_BY")
    private String approveBy;
    @Column(name = "IS_SLA_FAILED")
    private Boolean isSlaFailed;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

}