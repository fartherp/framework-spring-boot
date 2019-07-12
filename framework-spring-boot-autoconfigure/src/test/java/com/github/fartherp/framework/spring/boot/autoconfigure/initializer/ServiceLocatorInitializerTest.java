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
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA.
 *
 * @author CK
 * @date 2018/5/22
 */
public class ServiceLocatorInitializerTest {

	private ServiceLocatorInitializer serviceLocatorInitializer = new ServiceLocatorInitializer();

    @Test
    public void testInitialize() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.github.fartherp.framework.spring.boot.autoconfigure.initializer");
		context.refresh();

		serviceLocatorInitializer.initialize(context);
        UserService service = ServiceLocator.getBean("userService");
        assertThat(service.getName()).isEqualTo("UserTest");
    }

}
