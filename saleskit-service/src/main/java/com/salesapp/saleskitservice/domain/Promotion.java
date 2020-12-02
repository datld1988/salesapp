package com.salesapp.saleskitservice.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SAPP_KHUYEN_MAI")
@Data
public class Promotion implements Serializable {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TEN_CHUONG_TRINH")
    private String name;

    @Column(name = "ID_SAN_PHAM")
    private Integer productId;

    @Column(name = "TG_BAT_DAU")
    private Date timeStart;

    @Column(name = "TG_KET_THUC")
    private Date timeEnd;

    @Column(name = "ND_TOM_TAT")
    private String shortContent;

    @Column(name = "ND_CHI_TIET")
    private String content;

    @Column(name = "ANH_1")
    private String image1;

    @Column(name = "ANH_2")
    private String image2;

    @Column(name = "TRANG_THAI")
    private Integer status;

    @Column(name = "NGAY_TAO")
    private Date createDate;

    @Column(name = "NGUOI_TAO")
    private String createBy;

    @Column(name = "NGAY_SUA")
    private Date modifyDate;

    @Column(name = "NGUOI_SUA")
    private String modifyBy;

    @Column(name = "IS_DUYET")
    private Integer isApprove;

    @Column(name = "NGAY_DUYET")
    private Date approveDate;

    @Column(name = "NGUOI_DUYET")
    private String approveBy;

    @Column(name = "LY_DO_TU_CHOI")
    private String reasonReject;

    @Column(name = "DA_DUYET")
    private Integer isApproved;

    @Column(name = "VERSION")
    private Integer version;

    @Column(name = "ID_SP_PARENT")
    private Integer idProductParent;
}
