package com.salesapp.adminservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRegistrationDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

}
