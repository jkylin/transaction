package com.bsoft.transaction.constant;

/**
 * 医保交易常量类
 * @author wangruix
 */
public class MedicalInsuranceConstant {
    /**
     * JNA编码系统属性
     */
    public static final String JNA_ENCODING_PROPERTY = "jna.encoding";
    /**
     * DLL字符的编码格式
     */
    public static final String JNA_ENCODING = "GBK";

    /**
     * DLL启动参数
     */
    public static final String START_VALUE = "12345678";

    /**
     * DLL输出参数内存空间
     */
    public static final int MEMORY_SIZE = 0x102400;

    /**
     * 业务异常消息码
     */
    public static final String BUSINESS_ERROR_CODE = "500";

    /**
     * 医保DLL名称，DLL需要放在jdk/bin目录下
     */
    public static final String DLL_NAME = "SendRcv4";



}
