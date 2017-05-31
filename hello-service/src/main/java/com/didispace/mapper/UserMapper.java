package com.didispace.mapper;

import com.didispace.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * Created by xuchuan on 2017/5/27.
 */

public interface UserMapper {
    @Insert("INSERT INTO tb_user(username, password) VALUES(#{username},#{password})")
    public int insertUser(@Param("username") String username, @Param("password") String password);

    public int insertUserWithBackId(User user);
}
