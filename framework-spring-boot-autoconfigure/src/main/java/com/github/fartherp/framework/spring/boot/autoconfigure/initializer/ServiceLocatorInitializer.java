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
package com.github.fartherp.framework.spring.boot.autoconfigure.initializer;

import com.github.fartherp.framework.core.bean.ServiceLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Spring Boot 初始化，往ServiceLocator中注入Context，可以使用ServiceLocator获取对象
 * <pre>
 *     T t = ServiceLocator.getBean("beanName");
 * </pre>
 *
 * @author CK
 * @date 2018/5/22
 */
public class ServiceLocatorInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceLocatorInitializer.class);

    @Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
        LOGGER.info("ServiceLocatorInitializer ServiceLocator Context Aware");
        ServiceLocator.setFactory(applicationContext);
    }
}
