package com.example.drug.service;

import com.alibaba.fastjson.JSONObject;
import com.example.drug.entity.UserInfo;
import com.example.drug.mapper.GuardianshipMapper;
import com.example.drug.mapper.UserMapper;
import com.example.drug.util.Constant;
import com.example.drug.util.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
@Transactional
public class GuardianshipService {
    @Autowired
    private GuardianshipMapper guardianshipMapper;
    @Autowired
    private UserMapper userMapper;

    public String addGuardianship(String account, String beaccount,String bepassword) {
        JSONObject res = new JSONObject();
        //验证密码
        UserInfo userInfo = userMapper.login(beaccount,bepassword);
        if (userInfo == null){
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.ERROR);
        }else if (account == null && account.length() != 11) {
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.ACCOUNT_ERROR);
        } else if (beaccount == null && beaccount.length() != 11) {
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.PASSWORD_ERROR);
        } else {
            int t = 0;
            try {
                t = guardianshipMapper.addGuardianship(account + beaccount, account, beaccount);
                if (t <= 0) {
                    res.put("code", Constant.ERROR_STATUS);
                    res.put("msg", Constant.ACCOUNT_ERROR);
                } else {
                    res.put("code", Constant.SUCCESS_STATUS);
                    res.put("msg", Constant.ACCOUNT_SUCCESS);
                }
            }catch (Exception e){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                res.put("code", Constant.ERROR_STATUS);
                res.put("msg", Constant.ADD_FAIL);
            }
            res.put("data", t);
        }
        return res.toJSONString();
    }

    public String removeGuardianship(String account, String beaccount) {
        JSONObject res = new JSONObject();
        if (TextUtil.isEmpty(account)) {
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.ERROR);
        } else {
            int t = guardianshipMapper.removeGuardianship(account + beaccount);
            if (t <= 0) {
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

    public String ByaccountGruandianships(String account) {
        JSONObject res = new JSONObject();
        if (TextUtil.isEmpty(account)) {
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.ERROR);
        } else {
            List<UserInfo> list = guardianshipMapper.ByaccountGruandianships(account);
            if (list == null) {
                res.put("code", Constant.ERROR_STATUS);
                res.put("msg", Constant.ERROR);
            } else {
                res.put("code", Constant.SUCCESS_STATUS);
                res.put("msg", Constant.SUCCESS);
            }
            res.put("data", list);
        }
        return res.toJSONString();
    }

    public String BybeaccountGruandianships(String account) {
        JSONObject res = new JSONObject();
        if (TextUtil.isEmpty(account)) {
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.ERROR);
        } else {
            List<UserInfo> list = guardianshipMapper.BybeaccountGruandianships(account);
            if (list == null) {
                res.put("code", Constant.ERROR_STATUS);
                res.put("msg", Constant.ERROR);
            } else {
                res.put("code", Constant.SUCCESS_STATUS);
                res.put("msg", Constant.SUCCESS);
            }
            res.put("data", list);
        }
        return res.toJSONString();
    }

}
