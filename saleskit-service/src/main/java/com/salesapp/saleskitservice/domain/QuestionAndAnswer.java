package com.salesapp.saleskitservice.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SAPP_QA")
@Data
public class QuestionAndAnswer implements Serializable {
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ID_SAN_PHAM")
    private Integer idSP;

    @Column(name = "CHU_DE_CAP_1")
    private Integer chuDeCap1;

    @Column(name = "CHU_DE_CAP_2")
    private Integer chuDeCap2;

    @Column(name = "ND_CAU_HOI")
    private String ndCauHoi;

    @Column(name = "ND_CAU_TRA_LOI")
    private String ndCauTraLoi;

    @Column(name = "TRANG_THAI")
    private Integer trangThai;

    @Column(name = "NGAY_TAO")
    private Date ngayTao;

    @Column(name = "NGUOI_TAO")
    private String nguoiTao;

    @Column(name = "NGAY_SUA")
    private Date ngaySua;

    @Column(name = "NGUOI_SUA")
    private String nguoiSua;

    @Column(name = "IS_DUYET")
    private Integer isDuyet;

    @Column(name = "NGAY_DUYET")
    private Date ngayDuyet;

    @Column(name = "NGUOI_DUYET")
    private String nguoiDuyet;

    @Column(name = "LY_DO_TU_CHOI")
    private String lyDoTuChoi;
}
