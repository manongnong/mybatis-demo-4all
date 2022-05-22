package org.mn.mybatis.xml;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mn.mybatis.annotation.DemoUserDao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DemoMain {
    public static void main(String[] args) throws IOException {
        runWithXML();
    }

    private static void runWithXML() throws IOException {
        String resource = "mybatis/xml/mybatis-config.xml" ;
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<DemoUser> demoUserList = session.selectList("org.mn.mybatis.xml.DemoUserMapper.selectList");
            System.out.println(demoUserList.size());
        } finally {
            session.close();
        }
    }


}
