package com.example.drug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/***
 *
 * 数据库设计
 *  用户表 userinfo
 *  id username account(phone) password
 *
 *  用药提醒表 remind
 *  id account drugimage drugname drugdesc drugcreatedtime drugtaketime drugstatus createdtime
 *
 *  监护人表 guardianship
 *  id account beaccount createdtime
 *
 */
@SpringBootApplication
public class DrugApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrugApplication.class, args);
    }

}
