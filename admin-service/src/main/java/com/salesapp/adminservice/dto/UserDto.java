package com.salesapp.adminservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String username;
    private String mail;
    private String phone;
    private String avatar;
    private String fullName;


}
