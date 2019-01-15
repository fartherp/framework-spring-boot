/*
 * Copyright (c) 2019. juzhen.io. All rights reserved.
 */

package com.github.fartherp.framework.spring.boot.test.autoconfigure;
import com.github.fartherp.framework.spring.boot.test.autoconfigure.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2019/1/15
 */
@ExtendWith(SpringExtension.class)
@FrameworkMockTest
@TestPropertySource(properties = {
        "fartherpmock.beanNames:*Service",
        "fartherpmock.packageNames:com.github.fartherp.framework.spring.boot.test.autoconfigure.service"
})
class FrameworkMockTestIntegrationTest {

    @Resource
    private UserService userService;

    @Test
    void testUserServiceConfiguration() {
        assertThat(userService.getName()).isEqualTo("UserTestMock");
    }
}
