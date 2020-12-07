package com.salesapp.adminservice.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetAllUserRequest {
    private Integer page;
    private Integer perPage;
}
