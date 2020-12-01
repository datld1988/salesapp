package com.salesapp.saleskitservice.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SAPP_DANH_MUC")
@Data
public class DanhMuc implements Serializable {
    public static String MetaPropId = "id";
    public static String MetaPropType = "type";
    public static String MetaPropName = "name";
    public static String MetaPropValue = "value";
    public static String MetaPropDescription = "description";
    public static String MetaPropNguoiTao = "nguoiTao";
    public static String MetaPropNgayTao = "ngayTao";
    public static String MetaPropNguoiSua = "nguoiSua";
    public static String MetaPropNgaySua = "ngaySua";
    public static String MetaPropStatus = "status";


    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "NAME")
    private String name;

    @Column(name = "VALUE")
    private String value;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "NGUOI_TAO")
    private String nguoiTao;

    @Column(name = "NGAY_TAO")
    private Date ngayTao;

    @Column(name = "NGUOI_SUA")
    private String nguoiSua;

    @Column(name = "NGAY_SUA")
    private Date ngaySua;

    @Column(name = "STATUS")
    private Integer status;

}
