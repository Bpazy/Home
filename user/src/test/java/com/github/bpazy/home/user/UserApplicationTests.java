package com.github.bpazy.home.user;

import com.github.bpazy.home.common.spring.Springs;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationTests {
    private static final String userId = "1";
    @Autowired
    private UserDao userDao;

    @Test
    public void testSaveUser() {
        User user = User.builder()
                .userId(userId)
                .username("wuyjzu")
                .nickname("吴彦祖")
                .email("wuyjzu@wuyjzu.org")
                .build();
        userDao.saveUser(user);
    }

    @Test
    public void testFindUser() {
        User user = userDao.findUser(userId);
        System.out.println(user);
    }

    @AfterClass
    public static void clear() {
        Springs.getBean(UserDao.class).deleteUser(userId);
    }
}
