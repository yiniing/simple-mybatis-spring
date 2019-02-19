package com.bj58.sms.bean;

import com.bj58.sms.mapper.RoleMapper;
import com.bj58.sms.mapper.UserMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

import java.beans.Introspector;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyining on 18/12/19 019.
 * 实现BeanFactoryPostProcessor只能修改BeanDefinition而不能添加
 */
@Component
public class SimpleDefinitionRegister implements BeanDefinitionRegistryPostProcessor {

    /**
     * 动态注册BeanDefinition
     * @param registry 注册器
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        //模拟扫描
        Class[] classes = new Class[]{UserMapper.class, RoleMapper.class};

        for (Class clazz : classes) {
            BeanDefinition beanDefinition = new RootBeanDefinition(SimpleFactoryBean.class);
            // 源码中使用构造函数的方式，我们使用set方式
//            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(clazz);
            beanDefinition.getPropertyValues().addPropertyValue("mapperInterface", clazz);

            //register BeanDefinition
            registry.registerBeanDefinition(Introspector.decapitalize(clazz.getSimpleName()), beanDefinition);
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //可以在启动前通过BeanFactory做点事情
//        System.out.println(beanFactory.getBeanDefinition("springService").getBeanClassName());
    }
}
