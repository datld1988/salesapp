package com.salesapp.adminservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AD_USER_ROLE")
@IdClass(AdUserRoleId.class)
public class AdUserRole {

    @Id
    @Column(name = "USER_ID")
    private String userId;

    @Id
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
