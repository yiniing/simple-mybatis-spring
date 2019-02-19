package com.bj58.sms.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * @author zhangyining on 18/12/19 019.
 */
public interface RoleMapper {

    @Select("select * from roles where roleId = 1")
    void say();
}
