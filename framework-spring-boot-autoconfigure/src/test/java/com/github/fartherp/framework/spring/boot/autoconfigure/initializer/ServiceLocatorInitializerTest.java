/*
 * Copyright (c) 2018. CK. All rights reserved.
 */

package com.github.fartherp.framework.spring.boot.autoconfigure.initializer;

import com.github.fartherp.framework.core.bean.ServiceLocator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: CK
 * @date: 2018/5/22
 */
@SpringBootApplication(scanBasePackages = {"com.github.fartherp.framework.spring.boot.autoconfigure.initializer"})
public class ServiceLocatorInitializerTest {
    private ConfigurableApplicationContext context;

    @BeforeEach
    public void init() {
        context = SpringApplication.run(ServiceLocatorInitializerTest.class);
    }

    @AfterEach
    public void closeContext() {
        SpringApplication.exit(context);
    }

    @Test
    public void initialize() {
        UserService service = ServiceLocator.getBean("userService");
        assertThat(service.getName()).isEqualTo("UserTest");
    }

}