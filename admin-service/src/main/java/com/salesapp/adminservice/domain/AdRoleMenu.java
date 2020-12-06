package com.salesapp.adminservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AD_ROLE_MENU")
@IdClass(AdRoleMenuId.class)
public class AdRoleMenu implements Serializable {

    @Id
    @Column(name = "ROLE_ID")
    private String roleId;

    @Id
    @Column(name = "MENU_ID")
    private String menuId;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "CREATE_BY")
    private String createBy;

    @Column(name = "MODIFY_DATE")
    private Date modifyDate;

    @Column(name = "MODIFY_BY")
    private String modifyBy;
}
