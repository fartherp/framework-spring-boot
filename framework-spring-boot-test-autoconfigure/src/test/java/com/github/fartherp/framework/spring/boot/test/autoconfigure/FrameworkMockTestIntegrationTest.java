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
package com.github.fartherp.framework.spring.boot.test.autoconfigure;

import com.github.fartherp.framework.spring.boot.test.autoconfigure.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA.
 *
 * @author CK
 * @date 2019/1/15
 */
@RunWith(SpringRunner.class)
@FrameworkMockTest
@TestPropertySource(properties = {
        "fartherpmock.beanNames:*Service",
        "fartherpmock.packageNames:com.github.fartherp.framework.spring.boot.test.autoconfigure.service"
})
public class FrameworkMockTestIntegrationTest {

    @Resource
    private UserService userService;

    @Test
	public void testUserServiceConfiguration() {
        assertThat(userService.getName()).isEqualTo("UserTestMock");
    }
}
