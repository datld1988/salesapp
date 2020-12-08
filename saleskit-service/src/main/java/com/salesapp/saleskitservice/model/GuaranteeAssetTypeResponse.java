package com.salesapp.saleskitservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GuaranteeAssetTypeResponse {

    private int id;

    private String guaranteeAssetTypeName;

    public GuaranteeAssetTypeResponse(String guaranteeAssetTypeName) {

        this.guaranteeAssetTypeName = guaranteeAssetTypeName;
    }
}
