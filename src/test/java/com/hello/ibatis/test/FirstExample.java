package com.hello.ibatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by wangjb-c on 2017/5/10.
 */
public class FirstExample {

    SqlSessionFactory factory = null;


    @Before
    public void init(){
        InputStream is = FirstExample.class.getResourceAsStream("config.xml");
        factory = new SqlSessionFactoryBuilder().build(is,"online");
    }

    @After
    public void destory(){
        factory = null;
    }

    /**
     * 同一个session，查询多次相同语句，第二次开始使用session内部缓存返回数据，如果执行更新删除操作，则清空缓存。
     * 不同session，查询多次相同语句，第二次开始使用
     * @throws Exception
     */
    @Test
    public void testCache() throws Exception{

        /*SqlSession session = factory.openSession();
        Employee employee = session.selectOne("com.hello.ibatis.test.EmployeeMapper.selectById", 100);
        //session.update("com.hello.ibatis.test.EmployeeMapper.update");
        //session.rollback();
        System.out.println(employee);
        employee = session.selectOne("com.hello.ibatis.test.EmployeeMapper.selectById", 100);
        System.out.println(employee);
        session.close();*/


        SqlSession session = factory.openSession();

        Configuration configuration = factory.getConfiguration();
        Employee employee1 = session.selectOne("com.hello.ibatis.test.EmployeeMapper.selectById", 100);
        System.out.println(employee1);

        Employee employee2 = session.selectOne("com.hello.ibatis.test.EmployeeMapper.selectById", 100);
        System.out.println(employee2);
        //session.update("com.hello.ibatis.test.EmployeeMapper.update");
        //session.commit();
        session.close();

        session = factory.openSession();
        Employee employee3 = session.selectOne("com.hello.ibatis.test.EmployeeMapper.selectById", 100);
        System.out.println(employee3);
        session.close();
    }



    @Test
    public void testInsert(){
        SqlSession session = factory.openSession();
        Employee employee1 = new Employee();
        //employee1.setEmployeeId(999);
        employee1.setFirstName("A21231");
        employee1.setLastName("a12DEL2a");
        employee1.setEmail("A21223@182.com");
        employee1.setSalary(new BigDecimal(100.1));
        int x = session.insert("com.hello.ibatis.test.EmployeeMapper.insertAutoKey", employee1);
        System.out.println(x+"  "+ employee1.getEmployeeId());
        session.commit();
        session.close();
    }

    @Test
    public void testLinkedHashMap(){
        final int size = 16;
        Map<String,String> map = new LinkedHashMap<String,String>(size, .75F, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                boolean tooBig = size() > size;
                if (tooBig) {
                    System.out.println("------" +eldest.getKey());
                }
                return tooBig;
            }
        };
        for(int i=0;i<20;i++){
            map.put("a"+i,"ds"+i);
            //map.put("b"+i,"bb"+i);
            if(i==15){
                map.get("a0");
                map.get("a1");
            }
        }
    }


    @Test
    public void testClassForName(){
        String clazz = "";
    }
}
