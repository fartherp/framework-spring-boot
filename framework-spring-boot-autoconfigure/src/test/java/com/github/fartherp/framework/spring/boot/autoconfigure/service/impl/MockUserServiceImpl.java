/*
 * Copyright (c) 2019. CK. All rights reserved.
 */

package com.github.fartherp.framework.spring.boot.autoconfigure.service.impl;

import com.github.fartherp.framework.spring.boot.autoconfigure.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 *
 * @author CK
 * @date 2019/1/15
 */
@Service("mockUserManager")
public class MockUserServiceImpl implements UserService {
    public String getName() {
        return "UserTestMock";
    }
}
