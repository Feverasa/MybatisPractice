package com.fev;

import com.fev.mapper.UserMapper;
import com.fev.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * * Description:
 * * Author: fev
 * * Date: 2019/4/9 22:31
 * * version: V1.0
 */
public class MybatisTest {

    @Test
    public void test1() throws IOException {
        //获取mybatis全局配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //读取配置文件的配置信息，利用SqlSessionFactoryBuilder创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //利用sqlSessionFactory打开与数据库的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);//通过sqlSession得到mapper

            User user = new User();
            user.setAge(3);
            user.setName("火锅");
            userMapper.insertUser(user);//调用mapper的方法
            sqlSession.commit();//若是增、删、改操作，不添加此语句则数据库不更改
        } finally {
            sqlSession.close();
        }
    }

}
