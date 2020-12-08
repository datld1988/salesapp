package com.salesapp.saleskitservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GuaranteeMailTypeResponse {

    private int id;

    private String guaranteeEmailTypeName;

    public GuaranteeMailTypeResponse(String guaranteeEmailTypeName) {

        this.guaranteeEmailTypeName = guaranteeEmailTypeName;
    }
}
