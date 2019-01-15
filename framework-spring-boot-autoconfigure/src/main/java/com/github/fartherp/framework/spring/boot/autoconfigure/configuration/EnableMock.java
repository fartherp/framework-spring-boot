/*
 * Copyright (c) 2018. CK. All rights reserved.
 */

package com.github.fartherp.framework.spring.boot.autoconfigure.configuration;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: CK
 * @date: 2018/12/13
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MockServiceMarkerConfiguration.class)
public @interface EnableMock {
}
