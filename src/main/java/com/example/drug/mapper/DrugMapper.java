package com.example.drug.mapper;

import com.example.drug.entity.Remind;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("DrugMapper")
public interface DrugMapper {

    @Insert("insert into remind(account,drugimage,drugname,drugdesc,drugcreatedtime,drugtaketime) " +
            "values (#{account},#{drugimage},#{drugname},#{drugdesc},#{drugcreatedtime},#{drugtaketime})")
    int addDrug(String account, String drugimage, String drugname, String drugdesc, String drugcreatedtime, String drugtaketime);

    @Delete("delete from remind where id=#{id}")
    int removeDrug(String id);

    @Update("update remind set drugname=#{drugname}, drugimage=#{drugimage} , drugdesc=#{drugdesc} , drugcreatedtime=" +
            "#{drugcreatedtime} , drugtaketime=#{drugtaketime} where id=#{id}")
    int updateDrug(String drugname,String drugimage, String drugdesc, String drugcreatedtime, String drugtaketime, String id);

    @Select("select * from remind where account=#{account}")
    List<Remind> AllRemindData(String account);

    @Select("select * from remind where id=#{id}")
    Remind ByIdRemind(String id);

    @Update("update remind set drugstatus=#{b} where id=#{id}")
    int updateStatus(String b, String id);

    /**
     * 得到当前药物状态
     */
    @Select("select * from remind where id=#{id}")
    Remind ByIdRemindStatus(String id);

    /**
     * 获取remind所有数据状态为0的进行轮训
     */
    @Select("select * from remind as a inner join userinfo as b on a.account=b.account where drugstatus=#{status}")
    List<Remind> ByStatusRemindDatas(int status);

    /**
     * 修改发送状态
     */
    @Update("update remind set emailstatus=#{status} where id=#{id}")
    int updateRemindEmailStatus(int status,int id);
}
