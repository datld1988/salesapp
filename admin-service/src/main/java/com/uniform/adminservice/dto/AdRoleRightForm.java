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
@ApiModel("AdRoleRightForm - Gắn chức năng vào quyền")
public class AdRoleRightForm implements Serializable {

    @ApiModelProperty(name = "Mã PK", allowableValues = "", example = "", required =  true )
    private String id;
    
    @ApiModelProperty(name = "Mã PK Quyền", allowableValues = "", example = "", required =  true )
    private String roleId;
    
    @ApiModelProperty(name = "Mã PK Chức năng", allowableValues = "", example = "", required =  true )
    private String rightId;
    
    @ApiModelProperty(name = "Ngày tạo", allowableValues = "", example = "", required = false )
    private Date createdDate;
    
    @ApiModelProperty(name = "Người tạo", allowableValues = "", example = "", required = false )
    private String createdBy;
    
    @ApiModelProperty(name = "Ngày cập nhật", allowableValues = "", example = "", required = false )
    private Date modifiedDate;
    
    @ApiModelProperty(name = "Người cập nhật", allowableValues = "", example = "", required = false )
    private String modifiedBy;
    

}