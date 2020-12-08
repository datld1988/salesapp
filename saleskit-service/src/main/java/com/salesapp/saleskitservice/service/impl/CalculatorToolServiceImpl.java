package com.salesapp.saleskitservice.service.impl;

import com.salesapp.common.dto.Response;
import com.salesapp.saleskitservice.model.GuaranteeAssetTypeResponse;
import com.salesapp.saleskitservice.model.GuaranteeFeeResponse;
import com.salesapp.saleskitservice.model.GuaranteeMailTypeResponse;
import com.salesapp.saleskitservice.model.GuaranteeTypeResponse;
import com.salesapp.saleskitservice.service.CalculatorToolService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CalculatorToolServiceImpl implements CalculatorToolService {
    /**
     * @return
     */
    @Override
    public Response getGuaranteeFeeInformation() {

        // Data response
        GuaranteeFeeResponse guaranteeFeeResponse = new GuaranteeFeeResponse();

        // Danh sach loai bao lanh
        List<GuaranteeTypeResponse> lstGuaranteeTypeResponse = new ArrayList<GuaranteeTypeResponse>(
                Arrays.asList(
                        new GuaranteeTypeResponse("Bảo lãnh dự thầu"),
                        new GuaranteeTypeResponse("Bảo lãnh thanh toán"),
                        new GuaranteeTypeResponse("Bảo lãnh vay vốn"),
                        new GuaranteeTypeResponse("Bảo lãnh thanh toán tiền nộp thuế"),
                        new GuaranteeTypeResponse("Bảo lãnh dự thầu (đấu thầu bất động sản)"),
                        new GuaranteeTypeResponse("Bảo lãnh bảo hành"),
                        new GuaranteeTypeResponse("Bảo lãnh tạm ứng"),
                        new GuaranteeTypeResponse("Bảo lãnh thực hiện hơp đồng"),
                        new GuaranteeTypeResponse("Bảo lãnh hoàn quyết toán"),
                        new GuaranteeTypeResponse("Bảo lãnh đảm bảo môi trường, xã hội và sức khỏe")
                )
        );
        guaranteeFeeResponse.setLstGuaranteeTypeResponse(lstGuaranteeTypeResponse);

        // Danh sach tai san bao lanh
        List<GuaranteeAssetTypeResponse> lstGuaranteeAssetTypeResponse = new ArrayList<GuaranteeAssetTypeResponse>(
                Arrays.asList(
                        new GuaranteeAssetTypeResponse("Đảm bảo bằng sổ tiết kiệm do TPBank ban hành"),
                        new GuaranteeAssetTypeResponse("Đảm bảo bằng sổ tiết kiệm do tổ chức tín dụng khác ban hành được TPBank chấp nhận"),
                        new GuaranteeAssetTypeResponse("Đảm bảo bằng bất động sản, động sản"),
                        new GuaranteeAssetTypeResponse("Tín chấp"),
                        new GuaranteeAssetTypeResponse("Đảm bảo bằng ký quỹ của TBBank")
                )
        );
        guaranteeFeeResponse.setLstGuaranteeAssetTypeResponse(lstGuaranteeAssetTypeResponse);

        // Danh sach loai mau thu
        List<GuaranteeMailTypeResponse> lstGuaranteeMailTypeResponse = new ArrayList<GuaranteeMailTypeResponse>(
                Arrays.asList(
                        new GuaranteeMailTypeResponse("Theo mẫu TPB"),
                        new GuaranteeMailTypeResponse("Theo mẫu khách hàng - Mẫu thư vô điều kiện"),
                        new GuaranteeMailTypeResponse("Theo mẫu khách hàng - Mẫu thư có điều kiện"),
                        new GuaranteeMailTypeResponse("Thư bảo lãnh song ngữ (Anh - Việt)"),
                        new GuaranteeMailTypeResponse("Thư bảo lãnh xác định theo sự kiện"),
                        new GuaranteeMailTypeResponse("Thư bảo lãnh lần 2")
                )
        );
        guaranteeFeeResponse.setLstGuaranteeMailTypeResponse(lstGuaranteeMailTypeResponse);

        return Response.success(guaranteeFeeResponse);
    }
}
