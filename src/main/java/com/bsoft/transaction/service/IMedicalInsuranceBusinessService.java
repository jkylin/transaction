package com.bsoft.transaction.service;

import com.bsoft.transaction.entity.exception.BusinessException;

/**
 * 医保交易业务处理类
 * @author wangruix
 */
public interface IMedicalInsuranceBusinessService {


    /**
     * 发送消息体并获取返回值
     * @param message 入参
     * @return 返回值
     * @throws BusinessException 业务异常
     */
    String sendMessage(String message) throws BusinessException;


}
