package com.uniform.adminservice.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "AD_RIGHT")
@Data
public class AdRight implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "URL")
    private String url;
    @Column(name = "REQUEST_METHOD")
    private String requestMethod;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "STATUS_CODE")
    private String statusCode;
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

}