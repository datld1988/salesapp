package com.salesapp.saleskitservice.model;

import lombok.*;

@Getter
@Setter
@ToString
public class GuaranteeTypeResponse {

    private int id;

    private String guaranteeTypeName;

    public GuaranteeTypeResponse(String guaranteeTypeName) {

        this.guaranteeTypeName = guaranteeTypeName;
    }

}
