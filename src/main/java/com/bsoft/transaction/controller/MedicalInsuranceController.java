package com.bsoft.transaction.controller;

import com.bsoft.transaction.entity.exception.BusinessException;
import com.bsoft.transaction.service.IMedicalInsuranceBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 医保业务前端控制类
 *
 * @author wangruix
 */
@RestController
public class MedicalInsuranceController {

    @Autowired
    private IMedicalInsuranceBusinessService medicalInsuranceBusinessService;

    @PostMapping(value = "/WRL", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String sendMessage(@RequestBody String message) throws BusinessException {

        return medicalInsuranceBusinessService.sendMessage(message);
    }

}
