package com.uniform.processservice.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DataModelResult {
    private Object data;
    private ResultStatus resultStatus;
}
