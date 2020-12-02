package com.salesapp.saleskitservice.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SAPP_THUOC_TINH_NGHIEP_VU")
@Data
public class BusinessProperties implements Serializable {
    @Id
    @Column(name = "ID")
    private  Integer id;

    @Column(name = "ID_NV")
    private Integer businessId;

    @Column(name = "ND_TIEU_CHI")
    private String shortContent;

    @Column(name = "LOAI_THUOC_TINH")
    private Integer type;

    @Column(name = "NGUOI_TAO")
    private String createBy;

    @Column(name = "NGAY_TAO")
    private Date createDate;

    @Column(name = "NGUOI_SUA")
    private String modifyBy;

    @Column(name = "NGAY_SUA")
    private Date modifyDate;

    @Column(name = "TRANG_THAI")
    private Integer status;

    @Column(name = "ND_TIEU_CHI_CHI_TIET")
    private String content;

    @Column(name = "TEN_TIEU_CHI")
    private String name;

    @Column(name = "VERSION_NV")
    private Integer version;

}