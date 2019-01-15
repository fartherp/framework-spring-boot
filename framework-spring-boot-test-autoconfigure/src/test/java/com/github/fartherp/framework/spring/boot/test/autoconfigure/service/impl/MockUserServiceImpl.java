/*
 * Copyright (c) 2019. juzhen.io. All rights reserved.
 */

package com.github.fartherp.framework.spring.boot.test.autoconfigure.service.impl;

import com.github.fartherp.framework.spring.boot.test.autoconfigure.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2019/1/15
 */
@Service("mockUserManager")
public class MockUserServiceImpl implements UserService {
    public String getName() {
        return "UserTestMock";
    }
}
