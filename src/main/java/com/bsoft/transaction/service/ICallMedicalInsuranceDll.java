package com.bsoft.transaction.service;

import com.sun.jna.Library;
import com.sun.jna.Pointer;

/**
 * jna调用医保动态库
 * @author wangruix
 */
public interface ICallMedicalInsuranceDll extends Library {


    /**
     * 医保动态库所提供的方法
     * @param startParams 固定参数
     * @param input 入参
     * @param pointer 出参
     * @return 返回值
     */
    public String SendRcv4(String startParams, String input, Pointer pointer);

    /**
     * 医保动态库所提供的方法
     * @param startParams 固定参数
     * @param input 入参
     * @param pointer 出参
     * @return 返回值
     */
    public Pointer SendRcv4(String startParams, Pointer input, Pointer pointer);

    /**
     * 医保动态库所提供的方法
     * @param startParams 固定参数
     * @param input 入参
     * @param output 出参
     * @return 返回值
     */
    public String SendRcv4(String startParams, String input, byte[] output);

    /**
     * 医保动态库所提供的方法
     * @param startParams 固定参数
     * @param input 入参
     * @param output 出参
     * @return 返回值
     */
    public String SendRcv4(String startParams, byte[] input, byte[] output);

}
