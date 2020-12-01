package com.salesapp.adminservice.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UserRegistrationDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "Username {not.empty}")
    private String username;

    private String password;

}
