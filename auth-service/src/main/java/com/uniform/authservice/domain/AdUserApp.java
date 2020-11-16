package com.uniform.authservice.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "AD_USER_APP")
@Data
public class AdUserApp implements Serializable {

    @Id
    @Column(name = "ID")
    private String Id;
    @Column(name = "USER_ID")
    private String UserId;
    @Column(name = "APP_ID")
    private String AppId;
    @Column(name = "CREATED_DATE")
    private Date CreatedDate;
    @Column(name = "CREATED_BY")
    private String CreatedBy;
    @Column(name = "MODIFIED_DATE")
    private Date ModifiedDate;
    @Column(name = "MODIFIED_BY")
    private String ModifiedBy;

}