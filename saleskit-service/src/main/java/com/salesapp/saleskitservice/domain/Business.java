package com.salesapp.saleskitservice.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SAPP_NGHIEP_VU")
@Data
public class Business implements Serializable {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "MA_NV")
    private String businessCode;

    @Column(name = "MA_NV_CHA")
    private Integer businessParent;

    @Column(name = "TEN_NGHIEP_VU")
    private String name;

    @Column(name = "ND_TOM_TAT")
    private String shortContent;

    @Column(name = "TG_BAT_DAU")
    private Date timeStart;

    @Column(name = "TG_KET_THUC")
    private Date timeEnd;

    @Column(name = "NGAY_TAO")
    private Date createDate;

    @Column(name = "NGUOI_TAO")
    private String createBy;

    @Column(name = "NGAY_SUA")
    private Date modifyDate;

    @Column(name = "NGUOI_SUA")
    private String modifyBy;

    @Column(name = "TRANG_THAI")
    private Integer status;

    @Column(name = "ICON")
    private String icon;

    @Column(name = "IS_DUYET")
    private Integer isApprove;

    @Column(name = "NGAY_DUYET")
    private Date approveDate;

    @Column(name = "NGUOI_DUYET")
    private String approveBy;

    @Column(name = "LY_DO_TU_CHOI")
    private String reasonReject;

    @Column(name = "MENU_CO_DINH")
    private Integer staticMenu;

    @Column(name = "DA_DUYET")
    private Integer isApproved;

    @Column(name = "ID_NV_PARENT")
    private Integer businessParentId;

    @Column(name = "VERSION")
    private Integer version;

    @Column(name = "ANH_1")
    private String image1;

    @Column(name = "ANH_2")
    private String image2;
}
