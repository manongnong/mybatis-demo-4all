package org.mn.mybatis.annotation;

import org.apache.ibatis.annotations.Select;
import org.mn.mybatis.xml.DemoUser;

import java.util.List;

public interface DemoUserDao {
    @Select("select d.id, d.user_code, d.user_name, d.age from demo_user d")
    List<DemoUser> selectList();
}
