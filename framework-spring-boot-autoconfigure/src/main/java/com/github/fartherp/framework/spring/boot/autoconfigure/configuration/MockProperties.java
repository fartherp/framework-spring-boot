/**
 *    Copyright (c) 2018-2019 CK.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
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
