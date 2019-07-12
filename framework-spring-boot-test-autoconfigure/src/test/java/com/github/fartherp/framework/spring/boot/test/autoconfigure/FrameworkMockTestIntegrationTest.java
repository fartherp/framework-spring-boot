/*
 * Copyright (c) 2019. CK. All rights reserved.
 */

package com.github.fartherp.framework.spring.boot.test.autoconfigure;

import com.github.fartherp.framework.spring.boot.test.autoconfigure.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA.
 *
 * @author CK
 * @date 2019/1/15
 */
@RunWith(SpringRunner.class)
@FrameworkMockTest
@TestPropertySource(properties = {
        "fartherpmock.beanNames:*Service",
        "fartherpmock.packageNames:com.github.fartherp.framework.spring.boot.test.autoconfigure.service"
})
public class FrameworkMockTestIntegrationTest {

    @Resource
    private UserService userService;

    @Test
	public void testUserServiceConfiguration() {
        assertThat(userService.getName()).isEqualTo("UserTestMock");
    }
}
