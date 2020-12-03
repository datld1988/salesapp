package com.salesapp.adminservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AD_ROLE_MENU")
public class AdRoleMenu implements Serializable {

    @Id
    private String id;

    @Column(name = "ROLE_ID")
    private String roleId;

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
