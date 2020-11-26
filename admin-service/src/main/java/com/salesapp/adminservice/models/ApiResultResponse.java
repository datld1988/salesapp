package com.salesapp.adminservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResultResponse<T> {
    private String responseCode;
    private String responseMessage;
    private T data;
}
