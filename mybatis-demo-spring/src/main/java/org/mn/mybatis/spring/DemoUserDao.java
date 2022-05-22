package org.mn.mybatis.spring;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DemoUserDao {
    @Select("select d.id, d.user_code, d.user_name, d.age from demo_user d")
    List<DemoUser> selectList();

    List<DemoUser> selectList2();
}
