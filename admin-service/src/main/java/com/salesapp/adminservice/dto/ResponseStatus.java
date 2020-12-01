package com.salesapp.adminservice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("ResponseStatus - Trạng thái trả về")
public class ResponseStatus {
    @ApiModelProperty(name = "trạng thái thành công", allowableValues = "true/false", example = "true", required = true)
    private boolean success;
    @ApiModelProperty(name = "mã phản hồi", allowableValues = "ERROR, SUCCESS", example = "SUCCESS", required = true)
    private String code;
    @ApiModelProperty(name = "thông báo", example = "Xử lý thành công", required = false)
    private String msg;

    public static ResponseStatus defaultSuccess(String msg) {
        return new ResponseStatus(true, "SUCCESS", msg);
    }

    public static ResponseStatus defaultFailed(Exception e) {
        return new ResponseStatus(false, "SUCCESS", e.getMessage());
    }
}
