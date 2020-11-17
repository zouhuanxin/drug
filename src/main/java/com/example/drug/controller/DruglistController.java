package com.example.drug.controller;

import com.example.drug.service.DruglistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DruglistController {
    @Autowired
    private DruglistService druglistService;

    @GetMapping("getByAccountDruglist1")
    public String getByAccountDruglist1(String account){
        return druglistService.getByAccountDruglist1(account);
    }

    @GetMapping("getByIdDruglist2")
    public String getByIdDruglist2(String id){
        return druglistService.getByIdDruglist2(id);
    }

    @GetMapping("deleteByIdDruglist1")
    public String deleteByIdDruglist1(String id){
        return druglistService.deleteByIdDruglist1(id);
    }

    @GetMapping("deleteByIdDruglist2")
    public String deleteByIdDruglist2(String id){
        return druglistService.deleteByIdDruglist2(id);
    }

    @PostMapping("addDruglist1")
    public String addDruglist1(@RequestBody Map params){
        return druglistService.addDruglist1(params.get("name").toString(),
                params.get("account").toString());
    }

    @PostMapping("addDruglist2")
    public String addDruglist2(@RequestBody Map params){
        return druglistService.addDruglist2(params.get("id2").toString(),
                params.get("drugimage").toString(),
                params.get("drugname").toString(),
                params.get("drugdesc").toString(),
                params.get("drugcreatedtime").toString());
    }

    @PostMapping("updateDruglist1")
    public String updateDruglist1(@RequestBody Map params){
        return druglistService.updateDruglist1(params.get("id").toString(),
                params.get("name").toString());
    }

    @PostMapping("updateDruglist2")
    public String updateDruglist2(@RequestBody Map params){
        return druglistService.updateDruglist2(params.get("id").toString(),
                params.get("drugimage").toString(),
                params.get("drugname").toString(),
                params.get("drugdesc").toString(),
                params.get("drugcreatedtime").toString());
    }

}
