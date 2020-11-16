package com.uniform.adminservice.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "AD_APP")
@Data
public class AdApp implements Serializable {

    @Id
    @Column(name = "ID")
    private String Id;
    @Column(name = "APP_NAME")
    private String AppName;
    @Column(name = "SECRET_KEY")
    private String SecretKey;
    @Column(name = "PUBLIC_KEY")
    private String PublicKey;
    @Column(name = "DESCRIPTION")
    private String Description;
    @Column(name = "CREATED_DATE")
    private Date CreatedDate;
    @Column(name = "CREATED_BY")
    private String CreatedBy;
    @Column(name = "MODIFIED_DATE")
    private Date ModifiedDate;
    @Column(name = "MODIFIED_BY")
    private String ModifiedBy;

}