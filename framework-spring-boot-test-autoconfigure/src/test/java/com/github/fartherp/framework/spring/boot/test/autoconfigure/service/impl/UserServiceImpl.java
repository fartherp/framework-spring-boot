/*
 * Copyright (c) 2019. juzhen.io. All rights reserved.
 */

package com.github.fartherp.framework.spring.boot.test.autoconfigure.service.impl;

import com.github.fartherp.framework.spring.boot.test.autoconfigure.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: CK
 * @date: 2018/5/22
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    public String getName() {
        return "UserTest";
    }
}
