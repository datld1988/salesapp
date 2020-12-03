package com.salesapp.saleskitservice.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserNewsViewDto {
    @NotNull(message = "idUser {not.empty}")
    private String idUser;
}
