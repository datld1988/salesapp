package com.salesapp.adminservice.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FilterUserRequest {
    private String keyword;
    private String role;
    private Integer status;
    private Integer page;
    private Integer perPage;
}
