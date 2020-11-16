package com.uniform.authservice.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "AD_GROUP_USER")
@Data
public class AdGroupUser implements Serializable {

    @Id
    @Column(name = "ID")
    private String Id;
    @Column(name = "GROUP_ID")
    private String GroupId;
    @Column(name = "USER_ID")
    private String UserId;
    @Column(name = "CREATED_DATE")
    private Date CreatedDate;
    @Column(name = "CREATED_BY")
    private String CreatedBy;
    @Column(name = "MODIFIED_DATE")
    private Date ModifiedDate;
    @Column(name = "MODIFIED_BY")
    private String ModifiedBy;

}