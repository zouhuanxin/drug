package com.example.drug.mapper;

import com.example.drug.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("UserMapper")
public interface UserMapper {

    @Select("select * from userinfo where account=#{account} and password=#{password}")
    UserInfo login(String account,String password);

    @Insert("insert into userinfo(account,username,password)values(#{account},#{username},#{password})")
    int register(String account,String password,String username);

    /**
     * 修改密码
     */
    @Update("update userinfo set password=#{password} where account=#{account}")
    int updatePass(String account,String password);

    /**
     * 修改用户名
     */
    @Update("update userinfo set username=#{username} where account=#{account}")
    int updateUsername(String account,String username);
}
