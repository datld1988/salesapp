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
@ApiModel("UserBranchVwForm - Danh sách chi nhánh của người dùng")
public class UserBranchVwForm implements Serializable {

    @ApiModelProperty(name = "Mã PK chi nhánh", allowableValues = "", example = "", required =  true )
    private String id;
    
    @ApiModelProperty(name = "Tên chi nhánh", allowableValues = "", example = "", required = false )
    private String branchName;
    
    @ApiModelProperty(name = "Trạng thái sử dụng A, I, L, D", allowableValues = "", example = "", required = false )
    private String statusCode;
    
    @ApiModelProperty(name = "Mã PK Người dùng", allowableValues = "", example = "", required = false )
    private String userId;
    

}