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
@ApiModel("AdMenuForm - Menu")
public class AdMenuForm implements Serializable {

    @ApiModelProperty(name = "Mã PK", allowableValues = "", example = "", required =  true )
    private String id;
    
    @ApiModelProperty(name = "Url", allowableValues = "", example = "", required = false )
    private String url;
    
    @ApiModelProperty(name = "Tên hiển thị", allowableValues = "", example = "", required = false )
    private String name;
    
    @ApiModelProperty(name = "Mô tả", allowableValues = "", example = "", required = false )
    private String description;
    
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