package org.mn.mybatisplus.springboot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.mn.mybatisplus.springboot.dao.DemoUserDao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@MapperScan(basePackages = {"org.mn.mybatisplus.**.dao"})
public class DemoMain implements CommandLineRunner {
    public static void main(String[] args)  {
        SpringApplication.run(DemoMain.class, args);

    }
    @Autowired
    private DemoUserDao demoUserDao;

    @Override
    public void run(String... args) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_code","tom");
        queryWrapper.select("user_code");
        List<DemoUser> demoUserList = demoUserDao.selectList(queryWrapper);
        System.out.println(demoUserList.size());

//        UpdateWrapper<DemoUser> userUpdateWrapper = new UpdateWrapper<>();
//        userUpdateWrapper.set("user_code","tom1");
//        userUpdateWrapper.eq("user_code","tom");
//
//        int count = demoUserDao.update(null,userUpdateWrapper);
//        System.out.println(demoUserList.size());
    }

}
