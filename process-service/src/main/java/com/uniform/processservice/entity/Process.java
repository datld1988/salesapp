package com.uniform.processservice.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PROCESS")
@Data
public class Process implements Serializable {

    @Id
    @Column(name = "ID")
    private String Id;
    @Column(name = "CODE")
    private String Code;
    @Column(name = "STATUS_ID")
    private String StatusId;
    @Column(name = "BRANCH_CODE")
    private String BranchCode;
    @Column(name = "INPUT_DATE")
    private Date InputDate;
    @Column(name = "INPUT_BY")
    private String InputBy;
    @Column(name = "APPROVE_DATE")
    private Date ApproveDate;
    @Column(name = "APPROVE_BY")
    private String ApproveBy;
    @Column(name = "IS_SLA_FAILED")
    private Boolean IsSlaFailed;
    @Column(name = "CREATED_BY")
    private String CreatedBy;
    @Column(name = "CREATED_DATE")
    private Date CreatedDate;
    @Column(name = "MODIFIED_BY")
    private String ModifiedBy;
    @Column(name = "MODIFIED_DATE")
    private Date ModifiedDate;

}