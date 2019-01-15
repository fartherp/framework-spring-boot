/*
 * Copyright (c) 2019. CK. All rights reserved.
 */

package com.github.fartherp.framework.spring.boot.autoconfigure.configuration;

import com.github.fartherp.framework.core.bean.ServiceLocator;
import com.github.fartherp.framework.core.proxy.PackageNameAutoProxyCreator;
import com.github.fartherp.framework.core.web.interceptor.MockInterceptor;
import com.github.fartherp.framework.spring.boot.autoconfigure.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2019/1/15
 */
class MockAutoConfigurationTest {

    private AnnotationConfigApplicationContext context;

    @BeforeEach
    void setUp() {
        this.context = new AnnotationConfigApplicationContext();
    }

    @AfterEach
    void tearDown() {
        if (this.context != null) {
            this.context.close();
        }
    }

    @Test
    void testDefaultConfiguration() {
        ServiceLocator.setFactory(this.context);
        TestPropertyValues.of("fartherpmock.beanNames:*Service",
                "fartherpmock.packageNames:com.github.fartherp.framework.spring.boot.autoconfigure.service").applyTo(this.context);
        this.context.register(EnableMockConfiguration.class, MockAutoConfiguration.class);
        this.context.refresh();
        assertThat(this.context.getBean(MockInterceptor.class)).isInstanceOf(MockInterceptor.class);
        assertThat(this.context.getBean(BeanNameAutoProxyCreator.class)).isInstanceOf(PackageNameAutoProxyCreator.class);
    }

    @Test
    void testUserServiceConfiguration() {
        ServiceLocator.setFactory(this.context);
        TestPropertyValues.of("fartherpmock.beanNames:*Service",
                "fartherpmock.packageNames:com.github.fartherp.framework.spring.boot.autoconfigure.service").applyTo(this.context);
        this.context.register(ServiceConfiguration.class, MockAutoConfiguration.class);
        this.context.refresh();
        assertThat(this.context.getBean(MockInterceptor.class)).isInstanceOf(MockInterceptor.class);
        assertThat(this.context.getBean(BeanNameAutoProxyCreator.class)).isInstanceOf(PackageNameAutoProxyCreator.class);
        UserService userService = this.context.getBean("userService", UserService.class);
        assertThat(userService.getName()).isEqualTo("UserTestMock");
    }

    @Configuration
    @EnableMock
    static class EnableMockConfiguration {

    }

    @Configuration
    @EnableMock
    @ComponentScan("com.github.fartherp.framework.spring.boot.autoconfigure.service")
    static class ServiceConfiguration {

    }
}