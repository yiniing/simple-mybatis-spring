package com.bj58.sms.bean;

import com.bj58.sms.mapper.RoleMapper;
import com.bj58.sms.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhangyining on 18/12/17 017.
 */
@Service
public class SpringService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;

    public void userMapperSay(){
        userMapper.say();
    }

    public void roleMapperSay(){
        roleMapper.say();
    }
}
