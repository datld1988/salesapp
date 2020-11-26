package com.salesapp.saleskitservice.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "SAPP_THUOC_TINH_SAN_PHAM")
@Data
public class ProductProperties {
    @Id
    @Column(name = "ID")
    private  Integer id;

    @Column(name = "ID_SP")
    private Integer idSP;

    @Column(name = "ID_TIEU_CHI_DCP")
    private String idTieuChiDCP;

    @Column(name = "ND_TIEU_CHI")
    private String noiDungNgan;

    @Column(name = "LOAI_THUOC_TINH")
    private Integer loaiThuocTinh;

    @Column(name = "NGUOI_TAO")
    private String nguoiTao;

    @Column(name = "NGAY_TAO")
    private Date ngayTao;

    @Column(name = "NGUOI_SUA")
    private String nguoiSua;

    @Column(name = "NGAY_SUA")
    private Date ngaySua;

    @Column(name = "TRANG_THAI")
    private Integer trangThai;

    @Column(name = "ND_TIEU_CHI_CHI_TIET")
    private String ndChiTiet;

    @Column(name = "TEN_TIEU_CHI")
    private String tenTieuChi;



}
