package com.salesapp.customerservice.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PROCESS_NOTIFICATION")
@Data
public class ProcessNotification implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "MESSAGE")
    private String message;
    @Column(name = "URL")
    private String url;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "BRANCH_CODE")
    private String branchCode;
    @Column(name = "IS_READ")
    private Boolean isRead;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

}