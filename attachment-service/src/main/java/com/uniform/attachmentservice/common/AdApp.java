package com.uniform.attachmentservice.common;//package com.uniform.adminservice.domain;
//
//import lombok.Data;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import java.io.Serializable;
//import java.util.Date;
//
//@Entity
//@Table(name = "AD_APP")
//@Data
//public class AdApp implements Serializable {
//
//    @Id
//    @Column(name = "ID")
//    private String id;
//    @Column(name = "APP_NAME")
//    private String appName;
//    @Column(name = "APP_ID")
//    private String clientId;
//    @Column(name = "APP_SECRET")
//    private String clientSecret;
//    @Column(name = "AUTHORIZED_GRANT_TYPES")
//    private String authorizedGrantTypes;
//    @Column(name = "SCOPE")
//    private String scope;
//    @Column(name = "ACCESS_TOKEN_VALIDITY_SECONDS")
//    private String accessTokenValiditySeconds;
//    @Column(name = "REFRESH_TOKEN_VALIDITY_SECONDS")
//    private String refreshTokenValiditySeconds;
//    @Column(name = "SECRET_KEY")
//    private String secretKey;
//    @Column(name = "PUBLIC_KEY")
//    private String publicKey;
//    @Column(name = "DESCRIPTION")
//    private String description;
//    @Column(name = "CREATED_DATE")
//    private Date createdDate;
//    @Column(name = "CREATED_BY")
//    private String createdBy;
//    @Column(name = "MODIFIED_DATE")
//    private Date modifiedDate;
//    @Column(name = "MODIFIED_BY")
//    private String modifiedBy;
//
//}