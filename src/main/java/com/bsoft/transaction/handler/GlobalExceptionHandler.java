package com.bsoft.transaction.handler;

import com.bsoft.transaction.constant.MedicalInsuranceConstant;
import com.bsoft.transaction.entity.ReturnResult;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * @author wangruix
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    /**
     * 全局处理异常信息
     * @param ex 异常
     * @return 统一返回值
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ReturnResult globalException(Exception ex){
        logger.error(ExceptionUtils.getStackTrace(ex));
        ReturnResult returnResult = new ReturnResult();
        returnResult.setXxfhm(MedicalInsuranceConstant.BUSINESS_ERROR_CODE);
        returnResult.setFhxx(ex.getMessage());


        logger.info("全局异常处理返回：{}", returnResult);
        return returnResult;
    }


}
