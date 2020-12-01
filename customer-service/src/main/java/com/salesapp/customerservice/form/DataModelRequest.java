package com.salesapp.customerservice.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DataModelRequest {
    private String dataModel;
    private Map<String, String> parameters;
}
