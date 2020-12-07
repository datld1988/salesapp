package com.salesapp.adminservice.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdUserPortalDto implements Serializable {
    private String userId;
    private String password;
    private String fullName;
    private String phone;
    private String email;
    private String role;
    private Integer status;
    private String position;
}
