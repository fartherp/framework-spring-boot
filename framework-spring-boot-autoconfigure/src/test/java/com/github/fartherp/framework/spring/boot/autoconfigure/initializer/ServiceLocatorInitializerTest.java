/*
 * Copyright (c) 2018. juzhen.io. All rights reserved.
 */

package com.github.fartherp.framework.spring.boot.autoconfigure.initializer;

import com.github.fartherp.framework.core.bean.ServiceLocator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: CK
 * @date: 2018/5/22
 */
@SpringBootApplication(scanBasePackages = {"com.github.fartherp.framework.spring.boot.autoconfigure.initializer"})
public class ServiceLocatorInitializerTest {
    private ConfigurableApplicationContext context;

    @Before
    public void init() {
        context = SpringApplication.run(ServiceLocatorInitializerTest.class);
    }

    @After
    public void closeContext() {
        SpringApplication.exit(context);
    }

    @Test
    public void initialize() throws Exception {
        UserService service = ServiceLocator.getBean("userService");
        assertEquals(service.getName(), "UserTest");
    }

}