package com.example.drug.mapper;

import com.example.drug.entity.Druglist1;
import com.example.drug.entity.Druglist2;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("DruglistMapper")
public interface DruglistMapper {

    /**
     * 根据账号查询药物清单
     */
    @Select("select * from druglist1 where account=#{account}")
    List<Druglist1> getByAccountDruglist1(String account);

    /**
     * 根据药物清单id来查询所包含的药物
     */
    @Select("select * from druglist2 where id2=#{id}")
    List<Druglist2> getByIdDruglist2(int id);

    /**
     * 删除一个药物清单 根据id来删除
     */
    @Delete("delete from druglist1 where id=#{id}")
    int deleteByIdDruglist1(int id);

    /**
     * 添加一个药物清单
     */
    @Insert("insert into druglist1(name,account)values(#{name},#{account})")
    int addDruglist1(String name,String account);

    /**
     * 添加一个药物信息
     */
    @Insert("insert into druglist2(id2,drugimage,drugname,drugdesc,drugcreatedtime) " +
            "values(#{id2},#{drugimage},#{drugname},#{drugdesc},#{drugcreatedtime})")
    int addDruglist2(int id2,String drugimage,String drugname,String drugdesc,String drugcreatedtime);

    /**
     * 根据删除一个药物信息
     */
    @Delete("delete from druglist2 where id=#{id}")
    int deleteByIdDruglist2(int id);

    /**
     * 修改一个药物清单
     */
    @Update("update druglist1 set name=#{name} where id=#{id}")
    int updateDruglist1(int id,String name);

    /**
     * 修改一个药物信息
     */
    @Update("update druglist2 set drugimage=#{drugimage},drugname=#{drugname},drugdesc=#{drugdesc}" +
            ",drugcreatedtime=#{drugcreatedtime} where id=#{id}")
    int updateDruglist2(int id,String drugimage,String drugname,String drugdesc,String drugcreatedtime);
}
