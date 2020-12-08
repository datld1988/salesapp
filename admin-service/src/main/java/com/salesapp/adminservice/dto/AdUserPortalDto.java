package com.salesapp.adminservice.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdUserPortalDto implements Serializable {
    @NotNull(message = "userId {not.empty}")
    private String userId;
    @NotNull(message = "password {not.empty}")
    private String password;
    @NotNull(message = "fullName {not.empty}")
    private String fullName;
    private String phone;
    private String email;
    @NotNull(message = "role {not.empty}")
    private String role;
    @NotNull(message = "status {not.empty}")
    private Integer status;
    private String position;
}
