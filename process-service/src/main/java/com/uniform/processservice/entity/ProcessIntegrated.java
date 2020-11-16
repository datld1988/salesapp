package com.uniform.processservice.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PROCESS_INTEGRATED")
@Data
public class ProcessIntegrated implements Serializable {

    @Id
    @Column(name = "ID")
    private String Id;
    @Column(name = "PROCESS_ID")
    private String ProcessId;
    @Column(name = "STATUS_ID")
    private String StatusId;
    @Column(name = "TYPE")
    private String Type;
    @Column(name = "OBJECT_ID")
    private String ObjectId;
    @Column(name = "APPROVE_PRIORITY")
    private Integer ApprovePriority;
    @Column(name = "ACTION")
    private String Action;
    @Column(name = "DESCRIPTION")
    private String Description;
    @Column(name = "REQUEST_ID")
    private String RequestId;
    @Column(name = "SENT_DATE")
    private Date SentDate;
    @Column(name = "RECEIVE_DATE")
    private Date ReceiveDate;
    @Column(name = "RECEIVE_DATA")
    private String ReceiveData;
    @Column(name = "RE_TRY")
    private Integer ReTry;
    @Column(name = "APPROVE_DATE")
    private Date ApproveDate;
    @Column(name = "APPROVE_BY")
    private String ApproveBy;
    @Column(name = "CREATED_BY")
    private String CreatedBy;
    @Column(name = "CREATED_DATE")
    private Date CreatedDate;
    @Column(name = "MODIFIED_BY")
    private String ModifiedBy;
    @Column(name = "MODIFIED_DATE")
    private Date ModifiedDate;

}