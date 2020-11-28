package com.salesapp.customerservice.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResultStatus {
    private boolean success;
    private String code;
    private String msg;

    public static ResultStatus defaultSuccess(String msg) {
        return new ResultStatus(true, "SUCCESS", msg);
    }
    public static ResultStatus defaultFailed(Exception exp) {
        return new ResultStatus(false, "SUCCESS", exp.getMessage());
    }
}
