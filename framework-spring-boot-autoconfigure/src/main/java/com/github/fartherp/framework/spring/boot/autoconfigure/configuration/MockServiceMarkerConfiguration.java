/*
 * Copyright (c) 2018. CK. All rights reserved.
 */

package com.github.fartherp.framework.spring.boot.autoconfigure.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: CK
 * @date: 2018/12/13
 */
@Configuration
public class MockServiceMarkerConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public Marker eurekaServerMarkerBean() {
        return new Marker();
    }

    class Marker {

    }
}
