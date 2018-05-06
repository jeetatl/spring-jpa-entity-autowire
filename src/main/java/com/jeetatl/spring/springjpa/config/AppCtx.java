package com.jeetatl.spring.springjpa.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class AppCtx implements BeanFactoryAware {

    private static AutowireCapableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        AppCtx.beanFactory = (AutowireCapableBeanFactory) beanFactory;
    }

    public static AutowireCapableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
