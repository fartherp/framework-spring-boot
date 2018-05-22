/*
 * Copyright (c) 2018. juzhen.io. All rights reserved.
 */

package com.github.fartherp.framework.spring.boot.autoconfigure.initializer;

import com.github.fartherp.framework.core.bean.ServiceLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Spring Boot 初始化，往ServiceLocator中注入Context，可以使用ServiceLocator获取对象
 * <pre>
 *     T t = ServiceLocator.getBean("beanName");
 * </pre>
 *
 * @author: CK
 * @date: 2018/5/22
 */
public class ServiceLocatorInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    private final static Logger logger = LoggerFactory.getLogger(ServiceLocatorInitializer.class);

    public void initialize(ConfigurableApplicationContext applicationContext) {
        logger.info("ServiceLocatorInitializer ServiceLocator Context Aware");
        ServiceLocator.setFactory(applicationContext);
    }
}
