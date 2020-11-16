package com.uniform.adminservice.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "AD_RIGHT")
@Data
public class AdRight implements Serializable {

    @Id
    @Column(name = "ID")
    private String Id;
    @Column(name = "URL")
    private String Url;
    @Column(name = "REQUEST_METHOD")
    private String RequestMethod;
    @Column(name = "DESCRIPTION")
    private String Description;
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