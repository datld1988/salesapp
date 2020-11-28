package com.salesapp.adminservice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("DataResponse - Dữ liệu trả về")
public class DataResponse implements Serializable {
    @ApiModelProperty(name = "Đối chính tượng trả về", allowableValues = "", example = "", required = false)
    private Object item;
    @ApiModelProperty(name = "Danh sách đối chính tượng trả về", allowableValues = "", example = "", required = false)
    private Object items;
    @ApiModelProperty(name = "Trạng thái trả về", allowableValues = "", example = "", required = true)
    private ResponseStatus responseStatus;
}
