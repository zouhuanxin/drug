package com.example.drug.controller;

import com.example.drug.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class DrugController {
    @Autowired
    private DrugService drugService;

    @GetMapping("getAllDrugData")
    public String AllDrugData(String account) {
        return drugService.AllDrugData(account);
    }

    @PostMapping("addDrugData")
    public String addDrugData(@RequestBody Map params) {
        return drugService.addDrug(params.get("account").toString()
                , params.get("drugimage").toString()
                , params.get("drugname").toString()
                , params.get("drugdesc").toString()
                , params.get("drugcreatedtime").toString()
                , params.get("drugtaketime").toString());
    }

    @PostMapping("updateDrug")
    public String updateDrug(@RequestBody Map params) {
        return drugService.updateDrug(params.get("drugimage").toString()
                , params.get("drugdesc").toString()
                , params.get("drugcreatedtime").toString()
                , params.get("drugtaketime").toString()
                , params.get("id").toString());
    }

    @GetMapping("removeDrug")
    public String removeDrug(String id) {
        return drugService.removeDrug(id);
    }

    /**
     * get请求访问某个服药数据
     */
    @GetMapping("ByIdRemind")
    public String ByIdRemind(String id){
        return drugService.ByIdRemind(id);
    }

    /**
     * 签到服药提醒
     */
    @GetMapping("updateStatus")
    public String updateStatus(String b,String id){
        return drugService.updateStatus(b,id);
    }

    //http://123.57.45.169:8084/sign.html?id=1
    @RequestMapping(value = "/sign",method = {RequestMethod.GET})
    public String Sign(){
        return "sign";
    }








}
