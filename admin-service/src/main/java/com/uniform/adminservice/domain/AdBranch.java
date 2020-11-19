package com.uniform.adminservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AD_BRANCH")
public class AdBranch implements Serializable {
    
    public static String MetaPropId = "id";
    public static String MetaPropParentId = "parentId";
    public static String MetaPropName = "name";
    public static String MetaPropCode = "code";
    public static String MetaPropPhone = "phone";
    public static String MetaPropFax = "fax";
    public static String MetaPropContactName = "contactName";
    public static String MetaPropEmail = "email";
    public static String MetaPropAddress = "address";
    public static String MetaPropCityCode = "cityCode";
    public static String MetaPropDistrictCode = "districtCode";
    public static String MetaPropDisplayPriority = "displayPriority";
    public static String MetaPropStatusCode = "statusCode";
    public static String MetaPropCreatedBy = "createdBy";
    public static String MetaPropCreatedDate = "createdDate";
    public static String MetaPropModifiedBy = "modifiedBy";
    public static String MetaPropModifiedDate = "modifiedDate";

    @Id
    @Column(name = "ID")
    // Mã PK chi nhánh
    private String id;
    
    @Column(name = "PARENT_ID")
    // Mã cha
    private String parentId;
    
    @Column(name = "NAME")
    // Tên nhánh/phòng giao dịch
    private String name;
    
    @Column(name = "CODE")
    // Mã nhánh/phòng giao dịch
    private String code;
    
    @Column(name = "PHONE")
    // SĐT
    private String phone;
    
    @Column(name = "FAX")
    // Số FAX
    private String fax;
    
    @Column(name = "CONTACT_NAME")
    // Tên người liên hệ
    private String contactName;
    
    @Column(name = "EMAIL")
    // Địa chỉ Email
    private String email;
    
    @Column(name = "ADDRESS")
    // Địa chỉ nhánh/phòng giao dịch
    private String address;
    
    @Column(name = "CITY_CODE")
    // Mã Tỉnh/TP
    private String cityCode;
    
    @Column(name = "DISTRICT_CODE")
    // Mã Quận/Huyện
    private String districtCode;
    
    @Column(name = "DISPLAY_PRIORITY")
    // Thứ tự hiển thị, bắt đầu từ 1, nhỏ hơn lên đầu
    private Integer displayPriority;
    
    @Column(name = "STATUS_CODE")
    // Trạng thái sử dụng A, I, D
    private String statusCode;
    
    @Column(name = "CREATED_BY")
    // Người tạo
    private String createdBy;
    
    @Column(name = "CREATED_DATE")
    // Ngày tạo
    private Date createdDate;
    
    @Column(name = "MODIFIED_BY")
    // Người cập nhật
    private String modifiedBy;
    
    @Column(name = "MODIFIED_DATE")
    // Ngày cập nhật
    private Date modifiedDate;
    

}