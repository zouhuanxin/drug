package com.example.drug.service;

import com.alibaba.fastjson.JSONObject;
import com.example.drug.entity.Druglist1;
import com.example.drug.entity.Druglist2;
import com.example.drug.mapper.DruglistMapper;
import com.example.drug.util.Constant;
import com.example.drug.util.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DruglistService {
    @Autowired
    private DruglistMapper druglistMapper;

    /**
     * 查询
     */
    public String getByAccountDruglist1(String account) {
        JSONObject res = new JSONObject();
        List<Druglist1> list = druglistMapper.getByAccountDruglist1(account);
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

    public String getByIdDruglist2(String id) {
        JSONObject res = new JSONObject();
        List<Druglist2> list = druglistMapper.getByIdDruglist2(Integer.parseInt(id));
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

    public String deleteByIdDruglist1(String id) {
        JSONObject res = new JSONObject();
        int t = druglistMapper.deleteByIdDruglist1(Integer.parseInt(id));
        if (t <= 0) {
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.ERROR);
        } else {
            res.put("code", Constant.SUCCESS_STATUS);
            res.put("msg", Constant.SUCCESS);
        }
        return res.toJSONString();
    }

    public String deleteByIdDruglist2(String id) {
        JSONObject res = new JSONObject();
        int t = druglistMapper.deleteByIdDruglist2(Integer.parseInt(id));
        if (t <= 0) {
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.ERROR);
        } else {
            res.put("code", Constant.SUCCESS_STATUS);
            res.put("msg", Constant.SUCCESS);
        }
        return res.toJSONString();
    }

    /**
     * 添加药物
     */
    public String addDruglist2(String id2,String drugimage,String drugname,String drugdesc,String drugcreatedtime) {
        JSONObject res = new JSONObject();
        if (drugimage == null && drugimage.indexOf("http") == -1) {
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.ERROR);
        } else if (TextUtil.isEmpty(drugname) || TextUtil.isEmpty(drugdesc) || TextUtil.isEmpty(drugcreatedtime)) {
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.ERROR);
        } else {
            int t = druglistMapper.addDruglist2(Integer.parseInt(id2), drugimage, drugname, drugdesc, drugcreatedtime);
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
     * 添加药物清单
     */
    public String addDruglist1(String name,String account) {
        JSONObject res = new JSONObject();
        if (TextUtil.isEmpty(name) || TextUtil.isEmpty(account)) {
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.ERROR);
        } else {
            int t = druglistMapper.addDruglist1(name, account);
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

    public String updateDruglist1(String id,String name) {
        JSONObject res = new JSONObject();
        if (TextUtil.isEmpty(name) || TextUtil.isEmpty(id)) {
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.ERROR);
        } else {
            int t = druglistMapper.updateDruglist1(Integer.parseInt(id),name);
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

    public String updateDruglist2(String id,String drugimage,String drugname,String drugdesc,String drugcreatedtime) {
        JSONObject res = new JSONObject();
        if (TextUtil.isEmpty(id) || TextUtil.isEmpty(drugname) || TextUtil.isEmpty(drugdesc)
                || TextUtil.isEmpty(drugcreatedtime) || TextUtil.isEmpty(drugimage) ) {
            res.put("code", Constant.ERROR_STATUS);
            res.put("msg", Constant.ERROR);
        } else {
            int t = druglistMapper.updateDruglist2(Integer.parseInt(id),drugimage,drugname,drugdesc,drugcreatedtime);
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
