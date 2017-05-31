package com.didispace.dao;

/**
 * Created by xuchuan on 2017/5/27.
 */
import com.didispace.entity.User;
import com.didispace.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public int insertUser(String username, String password){
        return userMapper.insertUser(username, password);
    }

    public int insertUserWithBackId(User user){
        return userMapper.insertUserWithBackId(user);
    }

}