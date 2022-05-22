package org.mn.mybatis.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class DemoMain {
    public static void main(String[] args)  {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-main.xml");
        DemoUserDao demoUserDao =  ctx.getBean(DemoUserDao.class);
        List<DemoUser> demoUserList = demoUserDao.selectList();
        System.out.println(demoUserList.size());
        demoUserList = demoUserDao.selectList2();
        System.out.println(demoUserList.size());

    }

}
