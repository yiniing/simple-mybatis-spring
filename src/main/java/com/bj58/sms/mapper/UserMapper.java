package com.bj58.sms.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * @author zhangyining on 18/12/19 019.
 */
public interface UserMapper {

    @Select("select * from users where userId = 1")
    void say();
}
