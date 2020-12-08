package com.salesapp.saleskitservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class GuaranteeFeeResponse {
    
    private List<GuaranteeTypeResponse> lstGuaranteeTypeResponse;
    
    private List<GuaranteeAssetTypeResponse> lstGuaranteeAssetTypeResponse;
    
    private List<GuaranteeMailTypeResponse> lstGuaranteeMailTypeResponse;
}
