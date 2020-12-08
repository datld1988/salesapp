package com.salesapp.adminservice.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdUserPortalDto implements Serializable {
    @NotNull(message = "userId is not null")
    @NotEmpty(message = "userId is not empty")
    @NotBlank(message = "userId is not blank")
    private String userId;
    @NotNull(message = "password is not null")
    @NotEmpty(message = "password is not empty")
    @NotBlank(message = "password is not blank")
    private String password;
    @NotNull(message = "fullName {not.empty}")
    @NotEmpty(message = "fullName is not empty")
    private String fullName;
    private String phone;
    private String email;
    @NotNull(message = "role {not.empty}")
    @NotEmpty(message = "fullName is not empty")
    @NotBlank(message = "password is not blank")
    private String role;
    @NotNull(message = "status {not.empty}")
    private Integer status;
    private String position;
}
