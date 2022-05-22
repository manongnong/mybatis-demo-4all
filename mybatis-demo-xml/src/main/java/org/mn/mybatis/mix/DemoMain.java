package org.mn.mybatis.mix;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mn.mybatis.xml.DemoUser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DemoMain {
    public static void main(String[] args) throws IOException {
        runWithAnnotation();
    }


    private static void runWithAnnotation() throws IOException {
        String resource = "mybatis/mix/mybatis-config.xml" ;
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            DemoUserDao demoUserDao = session.getMapper(DemoUserDao.class);
            List<DemoUser> demoUserList = demoUserDao.selectList();
            System.out.println(demoUserList.size());
             demoUserList = demoUserDao.selectList2();
            System.out.println(demoUserList.size());
        } finally {
            session.close();
        }
    }
}
