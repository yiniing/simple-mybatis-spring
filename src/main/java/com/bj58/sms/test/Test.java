package com.bj58.sms.test;

import com.bj58.sms.bean.SpringService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhangyining on 19/2/18 018.
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringService bean = context.getBean(SpringService.class);
        bean.userMapperSay();
        bean.roleMapperSay();
    }
}
