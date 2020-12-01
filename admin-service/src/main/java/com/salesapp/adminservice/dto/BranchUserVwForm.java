package com.salesapp.adminservice.dto;

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
@ApiModel("BranchUserVwForm - Người dùng")
public class BranchUserVwForm implements Serializable {

    @ApiModelProperty(name = "Mã PK", allowableValues = "", example = "", required =  true )
    private String id;
    
    @ApiModelProperty(name = "Mã PK Chi nhánh", allowableValues = "", example = "", required = false )
    private String branchId;
    
    @ApiModelProperty(name = "Tên ứng dụng", allowableValues = "", example = "", required =  true )
    private String userName;
    
    @ApiModelProperty(name = "Secret Key để tạo chữ ký", allowableValues = "", example = "", required = false )
    private String email;
    
    @ApiModelProperty(name = "Public Key để mã hóa dữ liệu", allowableValues = "", example = "", required = false )
    private String phone;
    
    @ApiModelProperty(name = "Trạng thái sử dụng A, I, L, D", allowableValues = "", example = "", required = false )
    private String statusCode;
    
    @ApiModelProperty(name = "Ngày tạo", allowableValues = "", example = "", required = false )
    private Date createdDate;
    
    @ApiModelProperty(name = "Người tạo", allowableValues = "", example = "", required = false )
    private String createdBy;
    
    @ApiModelProperty(name = "Ngày cập nhật", allowableValues = "", example = "", required = false )
    private Date modifiedDate;
    
    @ApiModelProperty(name = "Người cập nhật", allowableValues = "", example = "", required = false )
    private String modifiedBy;
    

}