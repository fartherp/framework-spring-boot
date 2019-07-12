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

import com.github.fartherp.framework.core.bean.ServiceLocator;
import com.github.fartherp.framework.core.web.interceptor.MockInterceptor;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.fartherp.framework.core.proxy.PackageNameAutoProxyCreator;

/**
 * Created by IntelliJ IDEA.
 *
 * @author CK
 * @date 2018/12/13
 */
@Configuration
@ConditionalOnClass({MockInterceptor.class, PackageNameAutoProxyCreator.class})
@ConditionalOnBean(MockServiceMarkerConfiguration.Marker.class)
@EnableConfigurationProperties(MockProperties.class)
public class MockAutoConfiguration {

    private final MockProperties properties;

    public MockAutoConfiguration(MockProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean
    public MockInterceptor fartherpMockInterceptor() {
        MockInterceptor mockInterceptor = new MockInterceptor();
        mockInterceptor.setApplicationContext(ServiceLocator.getFactory());
        return mockInterceptor;
    }

    @Bean
    @ConditionalOnMissingBean
    public BeanNameAutoProxyCreator mockBeanNameAutoProxyCreator() {
        PackageNameAutoProxyCreator beanNameAutoProxyCreator = new PackageNameAutoProxyCreator();
        beanNameAutoProxyCreator.setInterceptorNames("fartherpMockInterceptor");
        beanNameAutoProxyCreator.setBeanNames(this.properties.getBeanNames());
        beanNameAutoProxyCreator.setPackageNames(this.properties.getPackageNames());
        return beanNameAutoProxyCreator;
    }
}
