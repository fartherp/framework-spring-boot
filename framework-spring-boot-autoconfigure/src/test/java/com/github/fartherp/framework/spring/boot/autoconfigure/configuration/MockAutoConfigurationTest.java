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
import com.github.fartherp.framework.spring.boot.autoconfigure.initializer.ServiceLocatorInitializer;
import com.github.fartherp.framework.spring.boot.autoconfigure.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA.
 *
 * @author CK
 * @date 2019/1/15
 */
public class MockAutoConfigurationTest {

	private ApplicationContextRunner contextRunner = new ApplicationContextRunner()
		.withInitializer(new ServiceLocatorInitializer())
		.withConfiguration(AutoConfigurations.of(MockAutoConfiguration.class))
		.withUserConfiguration(EnableMockConfiguration.class)
		.withPropertyValues("fartherpmock.beanNames:*Service",
			"fartherpmock.packageNames:com.github.fartherp.framework.spring.boot.autoconfigure.service");

	@Test
	public void testDefaultFartherpMockInterceptor() {
		this.contextRunner.run((context) -> {
			assertThat(context.getBean(MockInterceptor.class)).isNotNull();
		});
	}

	@Test
	public void testDefaultMockBeanNameAutoProxyCreator() {
		this.contextRunner.run((context) -> {
			assertThat(context.getBean(BeanNameAutoProxyCreator.class)).isNotNull();
		});
	}

	@Test
	public void testUserServiceConfiguration() {
		this.contextRunner.withUserConfiguration(ServiceConfiguration.class)
			.run((context) -> {
				ServiceLocator.setFactory(context);
				assertThat(context.getBean(BeanNameAutoProxyCreator.class)).isNotNull();
				UserService userService = context.getBean("userService", UserService.class);
				assertThat(userService.getName()).isEqualTo("UserTestMock");
			});
	}

	@Configuration
	@EnableMock
	public static class EnableMockConfiguration {

	}

	@Configuration
	@EnableMock
	@ComponentScan("com.github.fartherp.framework.spring.boot.autoconfigure.service")
	public static class ServiceConfiguration {

	}
}
