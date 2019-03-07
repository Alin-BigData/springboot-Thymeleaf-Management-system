package com.wfl.sampling.dao;


import com.wfl.sampling.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @ Author     ：wfl
 * @ Date       ：Created in 17:58 2018/12/18
 * @ Description：
 * @ Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersDaoTest {
    //让spring动态地将UserDao的mybatis实现类注入进来
    //spring code 的bean的级别降低
    @Autowired
    private UserDao userDao;
    @Test
    public void queryUsers() {
        List<User> userList = userDao.queryUsers();
        System.out.println(userList);
    }

    @Test
    public void queryUserByPhoneNum() {
        List<User> userList = userDao.queryUserByPhoneNum("13222222222");
        System.out.println(userList);
    }

    @Test
    public void queryUserByName() {
        List<User> userList = userDao.queryUserByName("wang");
        assertEquals(16,((List) userList).size());
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setPhoneNum("15932203413");
        user.setUserName("xiaowang");
        user.setSex("n");
        user.setCreateTime(new Date());
        user.setEmail("123123@132132");
        user.setPaperStatus(1);
        user.setPayStatus(1);
        userDao.insertUser(user);
    }
    @Test
    public void updateUser() {
        User user = new User();
        user.setPhoneNum("15759206413");
        user.setSex("n");
        user.setEmail("2fsdfa@jjfsd");
        user.setRegion("xiamenfd");
        user.setPayStatus(0);
        user.setPaperStatus(1);
        user.setProjectType(1);
        int effectNum = userDao.updateUser(user);
        System.out.println(effectNum);
    }

    @Test
    public void deleteUser() {
        userDao.deleteUser("15759206413");
    }
}