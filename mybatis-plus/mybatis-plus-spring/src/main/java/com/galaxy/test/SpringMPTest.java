package com.galaxy.test;

import com.galaxy.mapper.UserMapper;
import com.galaxy.pojo.User;
import lombok.AllArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author lane
 * @date 2021年10月16日 下午6:45
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringMPTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public  void springMPTest(){

        List<User> users = userMapper.selectList(null);
        users.forEach(user -> {
            System.out.println(user);
        });

    }

    @Test
    public  void springMPTest2(){

        List<User> users = userMapper.findAll();
        users.forEach(user -> {
            System.out.println(user);
        });

    }


}
