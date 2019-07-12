/*
 * Copyright (c) 2018. CK. All rights reserved.
 */

package com.github.fartherp.framework.spring.boot.autoconfigure.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by IntelliJ IDEA.
 *
 * @author CK
 * @date 2018/12/14
 */
@ConfigurationProperties(prefix = MockProperties.FARTHERP_MOCK_PREFIX)
public class MockProperties {
    public static final String FARTHERP_MOCK_PREFIX = "fartherpmock";

    private String[] beanNames;

    private String[] packageNames;

    public String[] getBeanNames() {
        return beanNames;
    }

    public void setBeanNames(String[] beanNames) {
        this.beanNames = beanNames;
    }

    public String[] getPackageNames() {
        return packageNames;
    }

    public void setPackageNames(String[] packageNames) {
        this.packageNames = packageNames;
    }
}
