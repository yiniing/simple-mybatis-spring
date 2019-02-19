package com.bj58.sms.bean;

import lombok.Data;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhangyining on 18/12/19 019.
 * <code>@Data 包含get、set、hashcode、equals和toString，可以根据需要选择</code>
 */
@Data
public class SimpleFactoryBean<T> implements FactoryBean {

    private Class<T> mapperInterface;

    private MapperInvocationHandler handler = new MapperInvocationHandler();


    /**
     * 这个是mybatis-spring源码的方式，个人建议对于bean的属性设置使用set的方式
     * 需要注意的是，如果使用set，需要提供set方法以及使用无参的构造函数
     */
//    public SimpleFactoryBean(Class<T> mapperInterface){
//        this.mapperInterface = mapperInterface;
//    }

    public SimpleFactoryBean(){

    }

    @Override
    @SuppressWarnings("unchecked")
    public T getObject() throws Exception {
        return (T)Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{mapperInterface}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    private static class MapperInvocationHandler implements InvocationHandler{

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // 模拟执行sql，这里只是打印sql语句
            System.out.println(method.getDeclaredAnnotation(Select.class).value()[0]);
            return null;
        }
    }
}
