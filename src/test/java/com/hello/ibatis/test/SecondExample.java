package com.hello.ibatis.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * <p></p>
 *
 * @author ooooow
 * @Since 2017/5/23
 */
public class SecondExample {

    SqlSessionFactory factory = null;


    @Before
    public void init(){
        InputStream is = SecondExample.class.getResourceAsStream("config.xml");
        factory = new SqlSessionFactoryBuilder().build(is);
    }

    @After
    public void destory(){
        factory = null;
    }

    @Test
    public void testCache() throws Exception{

        /*SqlSession session = factory.openSession();
        Employee employee = session.selectOne("com.hello.ibatis.test.EmployeeMapper.selectById", 100);
        //session.update("com.hello.ibatis.test.EmployeeMapper.update");
        System.out.println(employee);
        employee = session.selectOne("com.hello.ibatis.test.EmployeeMapper.selectById", 100);
        System.out.println(employee);
        session.close();*/


        SqlSession session = factory.openSession();
        Employee employee1 = session.selectOne("com.hello.ibatis.test.EmployeeMapper.selectById", 100);
        System.out.println(employee1);
        session.close();

        session = factory.openSession();
        Employee employee2 = session.selectOne("com.hello.ibatis.test.EmployeeMapper.selectById", 100);
        System.out.println(employee2);
        session.close();
    }
}
