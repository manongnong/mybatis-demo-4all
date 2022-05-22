package org.mn.mybatisplus.springboot;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.toolkit.SimpleQuery;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mn.mybatisplus.springboot.dao.DemoUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DemoTest {

    @Autowired
    private DemoUserDao demoUserDao;

    @Test
    public void testSelectAll() {
        List<DemoUser> demoUserList = demoUserDao.selectList(null);
        Assertions.assertEquals(2, demoUserList.size());
    }

    @Test
    public void testSelect() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_code","tom");
        queryWrapper.select("user_code");
        List<DemoUser> demoUserList = demoUserDao.selectList(queryWrapper);
        Assertions.assertEquals(1, demoUserList.size());
    }

    @Test
    public void testUpdate() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_code","tom");
        List<DemoUser> demoUserList = demoUserDao.selectList(queryWrapper);
        Assertions.assertEquals(1, demoUserList.size());

        //只会更新不为NULL字段
        DemoUser demoUserUpd = new DemoUser();
        demoUserUpd.setId(demoUserList.get(0).getId());
        demoUserUpd.setUserName("托姆1");
        demoUserDao.updateById(demoUserUpd);
        demoUserList = demoUserDao.selectList(queryWrapper);
        Assertions.assertTrue(demoUserList.get(0).getUserName().equals("托姆1"));

    }

    @Test
    public void testUpdateWapper1() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_code","tom");
        List<DemoUser> demoUserList = demoUserDao.selectList(queryWrapper);
        Assertions.assertEquals(1, demoUserList.size());

        DemoUser demoUserUpd = new DemoUser();
        demoUserUpd.setId(demoUserList.get(0).getId());
        demoUserUpd.setUserName("托姆1");
        //Warning updateWrapper 为null就没有条件了，所有的记录都更新了，慎用
        demoUserDao.update(demoUserUpd,null);
        demoUserList = demoUserDao.selectList(queryWrapper);
        Assertions.assertTrue(demoUserList.get(0).getUserName().equals("托姆1"));
    }


    @Test
    public void testUpdateWapper2() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_code","tom");
        List<DemoUser> demoUserList = demoUserDao.selectList(queryWrapper);
        Assertions.assertEquals(1, demoUserList.size());

        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.set("user_name","托姆2");
        updateWrapper.eq("id",demoUserList.get(0).getId());

        demoUserDao.update(null,updateWrapper);
        demoUserList = demoUserDao.selectList(queryWrapper);
        Assertions.assertTrue(demoUserList.get(0).getUserName().equals("托姆2"));
    }

    @Test
    public void testUpdateWapper3() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_code","tom");
        List<DemoUser> demoUserList = demoUserDao.selectList(queryWrapper);
        Assertions.assertEquals(1, demoUserList.size());
        //更新为NULL
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.set("user_name",null);
        updateWrapper.eq("id",demoUserList.get(0).getId());

        demoUserDao.update(null,updateWrapper);
        demoUserList = demoUserDao.selectList(queryWrapper);
        Assertions.assertTrue(StringUtils.isBlank(demoUserList.get(0).getUserName()));
    }
}
