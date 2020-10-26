package com.example.drug.controller;

import com.example.drug.service.GuardianshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GuardianshipController {
    @Autowired
    private GuardianshipService guardianshipService;

    @PostMapping("addGuardianship")
    public String addGuardianship(@RequestBody Map params){
        return guardianshipService.addGuardianship(params.get("account").toString(),
                params.get("beaccount").toString(),params.get("bepassword").toString());
    }

    @GetMapping("removeGuardianship")
    public String removeGuardianship(String account,String beaccount){
        return guardianshipService.removeGuardianship(account,beaccount);
    }

    @GetMapping("ByaccountGruandianships")
    public String ByaccountGruandianships(String account){
        return guardianshipService.ByaccountGruandianships(account);
    }

    @GetMapping("BybeaccountGruandianships")
    public String BybeaccountGruandianships(String account){
        return guardianshipService.BybeaccountGruandianships(account);
    }

}
