package com.galaxy.test;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.galaxy.mapper.UserMapper;
import com.galaxy.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author lane
 * @date 2021年10月16日 下午5:28
 */
public class MPTest {


    @Test
    public void testMysql() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.findAll();
        for (int i = 0; i < users.size(); i++) {
            User user =  users.get(i);
            System.out.println(user);
        }

    }


    @Test
    public void testMysqlMp() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new MybatisSqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> users = mapper.findAll();
        List<User> users = mapper.selectList(null);

        users.forEach(user -> {
            System.out.println(user);
        });

    }
}
