package com.example.drug.controller;

import com.example.drug.service.UserService;
import com.example.drug.util.SMSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.Callable;

@RestController
public class UserController {
    @Autowired
    private SMSUtil smsUtil;
    @Autowired
    private UserService userService;

    @GetMapping("test")
    public String test(){
        return "test";
    }

    /**
     * 登陆
     * @param params
     * @return
     */
    @PostMapping("login")
    public String login(@RequestBody Map params){
        return userService.login(params.get("account").toString(),params.get("password").toString());
    }

    /**
     *注册
     */
    @PostMapping("register")
    public String register(@RequestBody Map params){
        return userService.register(params.get("account").toString(),params.get("password").toString(),
                params.get("username").toString());
    }

    /**
     * 发送验证码
     */
    @GetMapping("sendSMS")
    public Callable<String> sendSMS(String phone){
        return smsUtil.sendVerificationCode(phone);
    }

    /**
     * 验证验证码
     */
    @GetMapping("verificationSMS")
    public Callable<String> verificationSMS(String phone,String code){
        return smsUtil.verificationCode(phone,code);
    }

    /**
     * 修改密码
     */
    @PostMapping("updatePass")
    public String updatePass(@RequestBody Map params){
        return userService.updatePass(params.get("account").toString(),
                params.get("password").toString());
    }

    /**
     * 修改用户名
     */
    @PostMapping("updateUsername")
    public String updateUsername(@RequestBody Map params){
        return userService.updatePass(params.get("account").toString(),
                params.get("username").toString());
    }
}
