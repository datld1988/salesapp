package com.salesapp.saleskitservice.domain;

import lombok.Data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "SAPP_SAN_PHAM")
@Data
public class SAPP_SAN_PHAM {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "MA_SP")
    private String maSP;

    @Column(name = "MA_SP_CHA")
    private String maSPCha;

    @Column(name = "TEN_SAN_PHAM")
    private String tenSP;

    @Column(name = "LOAI_SAN_PHAM")
    private String loaiSP;

    @Column(name = "ND_TOM_TAT")
    private String noiDungTomTat;

    @Column(name = "TG_BAT_DAU")
    private Date tgBatDau;

    @Column(name = "TG_KET_THUC")
    private Date tgKetThuc;

    @Column(name = "NGAY_TAO")
    private Date ngayTao;

    @Column(name = "NGUOI_TAO")
    private String nguoiTao;

    @Column(name = "NGAY_SUA")
    private Date ngaySua;

    @Column(name = "NGUOI_SUA")
    private String nguoiSua;

    @Column(name = "TRANG_THAI")
    private Integer trangThai;

    @Column(name = "ANH_1")
    private String anh_1;

    @Column(name = "ANH_2")
    private String anh_2;

    @Column(name = "ICON")
    private String icon;

    @Column(name = "HIEN_THI_KHCC")
    private Integer hienThiKHCC;

    @Column(name = "IS_DUYET")
    private Integer isDuyet;

    @Column(name = "NGAY_DUYET")
    private Date ngayDuyet;

    @Column(name = "NGUOI_DUYET")
    private String nguoiDuyet;

    @Column(name = "LY_DO_TU_CHOI")
    private String lyDoTuChoi;

    @Column(name = "MENU_CO_DINH")
    private Integer menuCoDinh;

    @Column(name = "HO_TRO_BC")
    private String hoTroBC;

    @Column(name = "DA_DUYET")
    private Integer daDuyet;

    @Column(name = "ID_SP_PARENT")
    private Integer idSPParent;

    @Column(name = "VERSION")
    private Integer version;
}
