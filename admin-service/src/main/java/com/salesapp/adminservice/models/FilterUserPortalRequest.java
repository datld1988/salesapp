package com.salesapp.adminservice.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FilterUserPortalRequest {
    private String keyword;
    private String role;
    private Integer status;
}
