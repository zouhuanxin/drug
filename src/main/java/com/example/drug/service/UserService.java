package com.example.drug.service;

import com.alibaba.fastjson.JSONObject;
import com.example.drug.entity.UserInfo;
import com.example.drug.mapper.UserMapper;
import com.example.drug.util.Constant;
import com.example.drug.util.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 登陆接口
     */
    public String login(String account, String password) {
        JSONObject res = new JSONObject();
        if (account == null && account.length() != 11) {
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.ACCOUNT_ERROR);
        } else if (password == null && password.equals("")) {
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.PASSWORD_ERROR);
        } else {
            UserInfo userInfo = userMapper.login(account, password);
            if (userInfo == null) {
                res.put("code", Constant.ERROR_STATUS);
                res.put("msg", Constant.ACCOUNT_ERROR);
            } else {
                res.put("code", Constant.SUCCESS_STATUS);
                res.put("msg", Constant.ACCOUNT_SUCCESS);
            }
            res.put("data", userInfo);
        }
        return res.toJSONString();
    }

    /**
     * 注册接口
     */
    public String register(String account, String password, String username) {
        JSONObject res = new JSONObject();
        if (account == null && account.length() != 11) {
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.ACCOUNT_ERROR);
        } else if (TextUtil.isEmpty(password)) {
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.PASSWORD_ERROR);
        } else if (TextUtil.isEmpty(username)) {
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.USERNAME_ERROR);
        } else {
            try {
                int t = userMapper.register(account, password, username);
                if (t == 0) {
                    res.put("code", Constant.ERROR_STATUS);
                    res.put("msg", Constant.ACCOUNT_ERROR);
                } else {
                    res.put("code", Constant.SUCCESS_STATUS);
                    res.put("msg", Constant.ACCOUNT_SUCCESS);
                }
                res.put("data", t);
            } catch (Exception e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                res.put("code", Constant.ERROR_STATUS);
                res.put("msg", Constant.ACCOUNT_ERROR);
            }
        }
        return res.toJSONString();
    }

    /**
     * 修改密码
     */
    public String updatePass(String account, String password) {
        JSONObject res = new JSONObject();
        if (TextUtil.isEmpty(account) || TextUtil.isEmpty(password)) {
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.ERROR);
        } else {
            int t = userMapper.updatePass(account, password);
            if (t == 0) {
                res.put("code", Constant.ERROR_STATUS);
                res.put("msg", Constant.ERROR);
            } else {
                res.put("code", Constant.SUCCESS_STATUS);
                res.put("msg", Constant.SUCCESS);
            }
            res.put("data", t);
        }
        return res.toJSONString();
    }

    /**
     * 修改用户名
     */
    public String updateUsername(String account, String username) {
        JSONObject res = new JSONObject();
        if (TextUtil.isEmpty(account) || TextUtil.isEmpty(username)) {
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.ERROR);
        } else {
            int t = userMapper.updateUsername(account, username);
            if (t == 0) {
                res.put("code", Constant.ERROR_STATUS);
                res.put("msg", Constant.ERROR);
            } else {
                res.put("code", Constant.SUCCESS_STATUS);
                res.put("msg", Constant.SUCCESS);
            }
            res.put("data", t);
        }
        return res.toJSONString();
    }

    /**
     * 修改邮箱
     */
    public String updateEmail(String account, String email) {
        JSONObject res = new JSONObject();
        if (TextUtil.isEmpty(account) || TextUtil.isEmpty(email)) {
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.ERROR);
        } else {
            int t = userMapper.updateEmail(account, email);
            if (t == 0) {
                res.put("code", Constant.ERROR_STATUS);
                res.put("msg", Constant.ERROR);
            } else {
                res.put("code", Constant.SUCCESS_STATUS);
                res.put("msg", Constant.SUCCESS);
            }
            res.put("data", t);
        }
        return res.toJSONString();
    }
}
