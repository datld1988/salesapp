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
@Table(name = "AD_APP")
public class AdApp implements Serializable {
    
    public static String MetaPropId = "id";
    public static String MetaPropAppName = "appName";
    public static String MetaPropSecretKey = "secretKey";
    public static String MetaPropPublicKey = "publicKey";
    public static String MetaPropDescription = "description";
    public static String MetaPropCreatedDate = "createdDate";
    public static String MetaPropCreatedBy = "createdBy";
    public static String MetaPropModifiedDate = "modifiedDate";
    public static String MetaPropModifiedBy = "modifiedBy";
    public static String MetaPropAppId = "appId";
    public static String MetaPropAppSecret = "appSecret";
    public static String MetaPropAuthorizedGrantTypes = "authorizedGrantTypes";
    public static String MetaPropScope = "scope";
    public static String MetaPropAccessTokenValiditySeconds = "accessTokenValiditySeconds";
    public static String MetaPropRefreshTokenValiditySeconds = "refreshTokenValiditySeconds";

    @Id
    @Column(name = "ID")
    // Mã PK
    private String id;
    
    @Column(name = "APP_NAME")
    // Tên ứng dụng
    private String appName;
    
    @Column(name = "SECRET_KEY")
    // Secret Key để tạo chữ ký
    private String secretKey;
    
    @Column(name = "PUBLIC_KEY")
    // Public Key để mã hóa dữ liệu
    private String publicKey;
    
    @Column(name = "DESCRIPTION")
    // Mô tả ứng dụng
    private String description;
    
    @Column(name = "CREATED_DATE")
    // Ngày tạo
    private Date createdDate;
    
    @Column(name = "CREATED_BY")
    // Người tạo
    private String createdBy;
    
    @Column(name = "MODIFIED_DATE")
    // Ngày cập nhật
    private Date modifiedDate;
    
    @Column(name = "MODIFIED_BY")
    // Người cập nhật
    private String modifiedBy;
    
    @Column(name = "APP_ID")
    // no comment
    private String appId;
    
    @Column(name = "APP_SECRET")
    // no comment
    private String appSecret;
    
    @Column(name = "AUTHORIZED_GRANT_TYPES")
    // no comment
    private String authorizedGrantTypes;
    
    @Column(name = "SCOPE")
    // no comment
    private String scope;
    
    @Column(name = "ACCESS_TOKEN_VALIDITY_SECONDS")
    // Thời gian hiệu lực cho Access Token
    private Long accessTokenValiditySeconds;
    
    @Column(name = "REFRESH_TOKEN_VALIDITY_SECONDS")
    // Thời gian hiệu lực cho Refresh Token
    private Long refreshTokenValiditySeconds;
    

}