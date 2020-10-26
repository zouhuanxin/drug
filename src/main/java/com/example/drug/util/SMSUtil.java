package com.example.drug.util;

import com.alibaba.fastjson.JSONObject;
import com.example.drug.http.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;

@Component
public class SMSUtil {
    @Autowired
    private HttpUtil httpUtil;

    /**
     * 发送bmob验证码
     */
    public Callable<String> sendVerificationCode(String phone){
        return new Callable<String>(){
            @Override
            public String call() throws Exception {
                return httpUtil.doPost("https://api2.bmob.cn/1/requestSmsCode", "{\"mobilePhoneNumber\": \""+phone+"\"}").body().string();
            }
        };
    }

    /**
     * 验证
     */
    public Callable<String> verificationCode(String phone,String code){
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                return httpUtil.doPost("https://api2.bmob.cn/1/verifySmsCode/"+code, "{\"mobilePhoneNumber\": \""+phone+"\"}").body().string();
            }
        };
    }

    /**
     * 发送短信推送
     */
    public void sendDrug(String phone,String url){
        //{"mobile":"xxxxxxxxxxx","sign_id":*,"temp_id":*}
        JSONObject req = new JSONObject();
        req.put("mobile","");
        req.put("sign_id","d28fedba40543d3cc7916bf9");
        req.put("temp_id","99ef421bc8b3b586da12785c");
        httpUtil.doPost("https://api.sms.jpush.cn/v1/codes", req.toJSONString(), new HttpUtil.HttpCallBack() {
            @Override
            public void Error() {

            }

            @Override
            public void Success(String str) {

            }
        });
    }

}
