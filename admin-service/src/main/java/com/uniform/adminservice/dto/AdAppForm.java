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
@ApiModel("AdAppForm - Ứng dụng")
public class AdAppForm implements Serializable {

    @ApiModelProperty(name = "Mã PK", allowableValues = "", example = "", required =  true )
    private String id;
    
    @ApiModelProperty(name = "Tên ứng dụng", allowableValues = "", example = "", required =  true )
    private String appName;
    
    @ApiModelProperty(name = "Secret Key để tạo chữ ký", allowableValues = "", example = "", required = false )
    private String secretKey;
    
    @ApiModelProperty(name = "Public Key để mã hóa dữ liệu", allowableValues = "", example = "", required = false )
    private String publicKey;
    
    @ApiModelProperty(name = "Mô tả ứng dụng", allowableValues = "", example = "", required = false )
    private String description;
    
    @ApiModelProperty(name = "Ngày tạo", allowableValues = "", example = "", required = false )
    private Date createdDate;
    
    @ApiModelProperty(name = "Người tạo", allowableValues = "", example = "", required = false )
    private String createdBy;
    
    @ApiModelProperty(name = "Ngày cập nhật", allowableValues = "", example = "", required = false )
    private Date modifiedDate;
    
    @ApiModelProperty(name = "Người cập nhật", allowableValues = "", example = "", required = false )
    private String modifiedBy;
    
    @ApiModelProperty(name = "no comment", allowableValues = "", example = "", required =  true )
    private String appId;
    
    @ApiModelProperty(name = "no comment", allowableValues = "", example = "", required =  true )
    private String appSecret;
    
    @ApiModelProperty(name = "no comment", allowableValues = "", example = "", required =  true )
    private String authorizedGrantTypes;
    
    @ApiModelProperty(name = "no comment", allowableValues = "", example = "", required =  true )
    private String scope;
    
    @ApiModelProperty(name = "Thời gian hiệu lực cho Access Token", allowableValues = "", example = "", required = false )
    private Long accessTokenValiditySeconds;
    
    @ApiModelProperty(name = "Thời gian hiệu lực cho Refresh Token", allowableValues = "", example = "", required = false )
    private Long refreshTokenValiditySeconds;
    

}