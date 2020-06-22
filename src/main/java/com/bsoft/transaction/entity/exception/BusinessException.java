package com.bsoft.transaction.entity.exception;

/**
 * 业务异常类
 * @author wangruix
 */
public class BusinessException extends Exception {


    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }
}
