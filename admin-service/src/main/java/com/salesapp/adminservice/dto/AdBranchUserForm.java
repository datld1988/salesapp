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
@ApiModel("AdBranchUserForm - Gắn người dùng vào chi nhánh")
public class AdBranchUserForm implements Serializable {

    @ApiModelProperty(name = "Mã PK", allowableValues = "", example = "", required =  true )
    private String id;
    
    @ApiModelProperty(name = "Mã PK Chi nhánh", allowableValues = "", example = "", required = false )
    private String branchId;
    
    @ApiModelProperty(name = "Mã PK Người dùng", allowableValues = "", example = "", required = false )
    private String userId;
    
    @ApiModelProperty(name = "Người tạo", allowableValues = "", example = "", required = false )
    private String createdBy;
    
    @ApiModelProperty(name = "Ngày tạo", allowableValues = "", example = "", required = false )
    private Date createdDate;
    
    @ApiModelProperty(name = "Người cập nhật", allowableValues = "", example = "", required = false )
    private String modifiedBy;
    
    @ApiModelProperty(name = "Ngày cập nhật", allowableValues = "", example = "", required = false )
    private Date modifiedDate;
    

}