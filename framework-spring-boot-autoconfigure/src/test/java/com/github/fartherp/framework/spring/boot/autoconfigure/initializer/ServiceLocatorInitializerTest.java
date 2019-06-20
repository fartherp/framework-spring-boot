/*
 * Copyright (c) 2018. CK. All rights reserved.
 */

package com.github.fartherp.framework.spring.boot.autoconfigure.initializer;

import com.github.fartherp.framework.core.bean.ServiceLocator;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: CK
 * @date: 2018/5/22
 */
public class ServiceLocatorInitializerTest {

	private ServiceLocatorInitializer serviceLocatorInitializer = new ServiceLocatorInitializer();

    @Test
    public void testInitialize() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.github.fartherp.framework.spring.boot.autoconfigure.initializer");
		context.refresh();

		serviceLocatorInitializer.initialize(context);
        UserService service = ServiceLocator.getBean("userService");
        assertThat(service.getName()).isEqualTo("UserTest");
    }

}
