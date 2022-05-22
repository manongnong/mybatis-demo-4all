package org.mn.mybatisplus.springboot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mn.mybatisplus.springboot.DemoUser;

import java.util.List;
//@Mapper
public interface DemoUserDao  extends BaseMapper<DemoUser> {
    @Select("select d.id, d.user_code, d.user_name, d.age from demo_user d")
    List<DemoUser> selectList3();

    List<DemoUser> selectList2();
}
