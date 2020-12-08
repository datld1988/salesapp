package com.salesapp.saleskitservice.controller;

import com.salesapp.common.dto.Response;
import com.salesapp.saleskitservice.service.CalculatorToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "guaranteefee")
public class GuaranteeFeeController {

    @Autowired
    CalculatorToolService calculatorToolService;

    /**
     * auth: anhld
     * date: 7/12/2020
     * lấy thông tin chi tiết của bảng tin
     * */
    @RequestMapping(path = "information", method = RequestMethod.GET)
    @ResponseBody
    public Response getInformation() {

        return calculatorToolService.getGuaranteeFeeInformation();
    }

}
