package com.salesapp.adminservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AD_USER_ROLE")
public class AdUserRole {

    @Id
    private String id;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "ROLE_ID")
    private String roleId;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "CREATE_BY")
    private String createBy;

    @Column(name = "MODIFY_DATE")
    private String modifyBy;

    @Column(name = "MODIFY_BY")
    private Date modifyDate;
}
