package com.example.drug.mapper;

import com.example.drug.entity.UserInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("GuardianshipMapper")
public interface GuardianshipMapper {

    /**
     * 添加一个监护人
     */
    @Insert("insert into guardianship(onlyaccount,account,beaccount)values(#{onlyaccount},#{account},#{beaccount})")
    int addGuardianship(String onlyaccount,String account,String beaccount);

    /**
     * 删除一个监护人
     */
    @Delete("delete from guardianship where onlyaccount=#{onlyaccount}")
    int removeGuardianship(String onlyaccount);

    /**
     * 根据账号查找所有的监护人
     */
    @Select("select b.account,b.username,b.password from guardianship as a inner join userinfo as b on a.beaccount=b.account " +
            "where a.account=#{account}")
    List<UserInfo> ByaccountGruandianships(String account);

    /**
     * 根据账号查询所有的被监护人
     */
    @Select("select * from guardianship as a inner join userinfo as b on a.account=b.account " +
            "where a.beaccount=#{account}")
    List<UserInfo> BybeaccountGruandianships(String account);
}
