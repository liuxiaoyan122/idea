package com.hp.service;

import com.hp.mapper.UserMapper;
import com.hp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User queryUserById(Long i){
        return userMapper.selectByPrimaryKey(i);
    }

    @Transactional
    public int  deleteUserById(Long id){
        int x=userMapper.deleteByPrimaryKey(id);
        return x;
    }

    public List<User> queryAllUser(){
        return userMapper.selectAll();
    }
}
