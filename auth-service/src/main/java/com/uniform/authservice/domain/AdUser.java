package com.uniform.authservice.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "AD_USER")
@Data
public class AdUser implements Serializable {

    @Id
    @Column(name = "ID")
    private String Id;
    @Column(name = "USER_NAME")
    private String UserName;
    @Column(name = "EMAIL")
    private String Email;
    @Column(name = "PHONE")
    private String Phone;
    @Column(name = "STATUS_CODE")
    private String StatusCode;
    @Column(name = "CREATED_DATE")
    private Date CreatedDate;
    @Column(name = "CREATED_BY")
    private String CreatedBy;
    @Column(name = "MODIFIED_DATE")
    private Date ModifiedDate;
    @Column(name = "MODIFIED_BY")
    private String ModifiedBy;

}