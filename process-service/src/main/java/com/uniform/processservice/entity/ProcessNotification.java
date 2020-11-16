package com.uniform.processservice.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PROCESS_NOTIFICATION")
@Data
public class ProcessNotification implements Serializable {

    @Id
    @Column(name = "ID")
    private String Id;
    @Column(name = "TYPE")
    private String Type;
    @Column(name = "MESSAGE")
    private String Message;
    @Column(name = "URL")
    private String Url;
    @Column(name = "USERNAME")
    private String Username;
    @Column(name = "BRANCH_CODE")
    private String BranchCode;
    @Column(name = "IS_READ")
    private Boolean IsRead;
    @Column(name = "CREATED_BY")
    private String CreatedBy;
    @Column(name = "CREATED_DATE")
    private Date CreatedDate;
    @Column(name = "MODIFIED_BY")
    private String ModifiedBy;
    @Column(name = "MODIFIED_DATE")
    private Date ModifiedDate;

}