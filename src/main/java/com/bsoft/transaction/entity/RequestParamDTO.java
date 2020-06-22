package com.bsoft.transaction.entity;

import java.io.Serializable;

/**
 * 入参实体类
 * @author wangruix
 */
public class RequestParamDTO implements Serializable {

    private static final long serialVersionUID = -2413244965952983215L;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "RequestParamDTO{" +
                "message='" + message + '\'' +
                '}';
    }
}
