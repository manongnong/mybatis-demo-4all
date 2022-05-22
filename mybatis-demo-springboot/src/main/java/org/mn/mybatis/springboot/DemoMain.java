package org.mn.mybatis.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@SpringBootApplication
@MapperScan(basePackages = {"org.mn.mybatis.springboot"})
public class DemoMain implements CommandLineRunner {
    public static void main(String[] args)  {
        SpringApplication.run(DemoMain.class, args);

    }
    @Autowired
    private  DemoUserDao demoUserDao;

    @Override
    public void run(String... args) {
        List<DemoUser> demoUserList = demoUserDao.selectList();
        System.out.println(demoUserList.size());
    }

}
