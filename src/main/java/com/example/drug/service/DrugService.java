package com.example.drug.service;

import com.alibaba.fastjson.JSONObject;
import com.example.drug.entity.Remind;
import com.example.drug.mapper.DrugMapper;
import com.example.drug.util.Constant;
import com.example.drug.util.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugService {
    @Autowired
    private DrugMapper drugMapper;

    /**
     * 查询
     */
    public String AllDrugData(String account) {
        JSONObject res = new JSONObject();
        List<Remind> list = drugMapper.AllRemindData(account);
        if (list == null) {
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.ERROR);
        } else {
            res.put("code", Constant.SUCCESS_STATUS);
            res.put("msg", Constant.SUCCESS);
        }
        res.put("data", list);
        return res.toJSONString();
    }

    /**
     * 添加服药提醒
     */
    public String addDrug(String account, String drugimage, String drugname, String drugdesc, String drugcreatedtime, String drugtaketime) {
        JSONObject res = new JSONObject();
        if (drugimage == null && drugimage.indexOf("http") == -1) {
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.ERROR);
        } else if (TextUtil.isEmpty(drugname) || TextUtil.isEmpty(drugdesc) || TextUtil.isEmpty(drugcreatedtime)
                || TextUtil.isEmpty(drugtaketime)) {
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.ERROR);
        } else {
            int t = drugMapper.addDrug(account, drugimage, drugname, drugdesc, drugcreatedtime, drugtaketime);
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

    /**
     * 修改
     */
    public String updateDrug(String drugimage, String drugdesc, String drugcreatedtime, String drugtaketime, String id) {
        JSONObject res = new JSONObject();
        if (drugimage == null && drugimage.indexOf("http") == -1) {
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.ERROR);
        } else if (TextUtil.isEmpty(drugdesc) || TextUtil.isEmpty(drugcreatedtime) || TextUtil.isEmpty(drugtaketime)
                || TextUtil.isEmpty(id)) {
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.ERROR);
        } else {
            int t = drugMapper.updateDrug(drugimage, drugdesc, drugcreatedtime, drugtaketime, id);
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

    /**
     * 删除
     */
    public String removeDrug(String id) {
        JSONObject res = new JSONObject();
        if (TextUtil.isEmpty(id)) {
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.ERROR);
        } else {
            int t = drugMapper.removeDrug(id);
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

    /**
     * 根据id来查询服药提醒
     */
    public String ByIdRemind(String id){
        JSONObject res = new JSONObject();
        if (TextUtil.isEmpty(id)) {
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.ERROR);
        } else {
            Remind remind = drugMapper.ByIdRemind(id);
            if (remind == null) {
                res.put("code", Constant.ERROR_STATUS);
                res.put("msg", Constant.ERROR);
            } else {
                res.put("code", Constant.SUCCESS_STATUS);
                res.put("msg", Constant.SUCCESS);
            }
            res.put("data", remind);
        }
        return res.toJSONString();
    }

    /**
     * 签到服药提醒
     */
    public synchronized String updateStatus(String b,String id){
        JSONObject res = new JSONObject();
        if (TextUtil.isEmpty(id)) {
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.ERROR);
            return res.toJSONString();
        }
        Remind remind = drugMapper.ByIdRemindStatus(id);
        if (remind.getDrugstatus() != 0){
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.SIGN_ALEARY);
        } else {
            int t = drugMapper.updateStatus(b,id);
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
}
