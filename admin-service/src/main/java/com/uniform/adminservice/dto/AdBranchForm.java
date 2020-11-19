package com.uniform.adminservice.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("AdBranchForm - Chi nhánh/phòng giao dịch")
public class AdBranchForm implements Serializable {

    @ApiModelProperty(name = "Mã PK chi nhánh", allowableValues = "", example = "", required =  true )
    private String id;
    
    @ApiModelProperty(name = "Mã cha", allowableValues = "", example = "", required = false )
    private String parentId;
    
    @ApiModelProperty(name = "Tên nhánh/phòng giao dịch", allowableValues = "", example = "", required = false )
    private String name;
    
    @ApiModelProperty(name = "Mã nhánh/phòng giao dịch", allowableValues = "", example = "", required = false )
    private String code;
    
    @ApiModelProperty(name = "SĐT", allowableValues = "", example = "", required = false )
    private String phone;
    
    @ApiModelProperty(name = "Số FAX", allowableValues = "", example = "", required = false )
    private String fax;
    
    @ApiModelProperty(name = "Tên người liên hệ", allowableValues = "", example = "", required = false )
    private String contactName;
    
    @ApiModelProperty(name = "Địa chỉ Email", allowableValues = "", example = "", required = false )
    private String email;
    
    @ApiModelProperty(name = "Địa chỉ nhánh/phòng giao dịch", allowableValues = "", example = "", required = false )
    private String address;
    
    @ApiModelProperty(name = "Mã Tỉnh/TP", allowableValues = "", example = "", required = false )
    private String cityCode;
    
    @ApiModelProperty(name = "Mã Quận/Huyện", allowableValues = "", example = "", required = false )
    private String districtCode;
    
    @ApiModelProperty(name = "Thứ tự hiển thị, bắt đầu từ 1, nhỏ hơn lên đầu", allowableValues = "", example = "", required = false )
    private Integer displayPriority;
    
    @ApiModelProperty(name = "Trạng thái sử dụng A, I, D", allowableValues = "", example = "", required = false )
    private String statusCode;
    
    @ApiModelProperty(name = "Người tạo", allowableValues = "", example = "", required = false )
    private String createdBy;
    
    @ApiModelProperty(name = "Ngày tạo", allowableValues = "", example = "", required = false )
    private Date createdDate;
    
    @ApiModelProperty(name = "Người cập nhật", allowableValues = "", example = "", required = false )
    private String modifiedBy;
    
    @ApiModelProperty(name = "Ngày cập nhật", allowableValues = "", example = "", required = false )
    private Date modifiedDate;
    

}