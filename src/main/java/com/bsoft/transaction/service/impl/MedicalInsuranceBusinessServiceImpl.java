package com.bsoft.transaction.service.impl;

import com.bsoft.transaction.constant.MedicalInsuranceConstant;
import com.bsoft.transaction.entity.exception.BusinessException;
import com.bsoft.transaction.service.ICallMedicalInsuranceDll;
import com.bsoft.transaction.service.IMedicalInsuranceBusinessService;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * 医保交互业务处理类
 * @author wangruix
 */
@Component
public class MedicalInsuranceBusinessServiceImpl implements IMedicalInsuranceBusinessService {

    private static ICallMedicalInsuranceDll callMedicalInsuranceDll;


    @Override
    public String sendMessage(String message) throws BusinessException {

        //设置JNA编码格式
        String jnaEncode = System.getProperty(MedicalInsuranceConstant.JNA_ENCODING_PROPERTY);
        if(StringUtils.isEmpty(jnaEncode)){
            System.setProperty(MedicalInsuranceConstant.JNA_ENCODING_PROPERTY, MedicalInsuranceConstant.JNA_ENCODING);
        }

        //实例化JNA接口
        if(callMedicalInsuranceDll == null){
            callMedicalInsuranceDll = Native.load(MedicalInsuranceConstant.DLL_NAME, ICallMedicalInsuranceDll.class);
        }

        Pointer pointer0 = new Memory((message.length() + 1) * 2);
        Pointer pointer1 = new Memory(MedicalInsuranceConstant.MEMORY_SIZE);
        pointer0.setString(0, message);

        try{
            callMedicalInsuranceDll.SendRcv4(MedicalInsuranceConstant.START_VALUE, pointer0, pointer1);

            return pointer1.getString(0, "GBK");
        }catch (Exception e){
            throw new BusinessException(e);
        }finally {
            long peer0 = Pointer.nativeValue(pointer0);
            Native.free(peer0);
            Pointer.nativeValue(pointer0, 0);

            long peer1 = Pointer.nativeValue(pointer1);
            Native.free(peer1);
            Pointer.nativeValue(pointer1, 0);
        }


        /*byte[] bytes = new byte[4000];
        callMedicalInsuranceDll.SendRcv4(MedicalInsuranceConstant.START_VALUE, message.getBytes(), bytes);
        String result = StringUtils.toEncodedString(bytes, Charset.forName("GBK"));
        return result;*/


        //指针方式作为出参
        /*Pointer pointer = new Memory(MedicalInsuranceConstant.MEMORY_SIZE);
        try{
            String result = callMedicalInsuranceDll.SendRcv4(MedicalInsuranceConstant.START_VALUE, message, pointer);
            return result;
        }catch(Exception e){
            throw new BusinessException(e);
        }finally {
            long peer = Pointer.nativeValue(pointer);
            Native.free(peer);
            Pointer.nativeValue(pointer, 0);
        }*/
    }
}
