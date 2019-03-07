package com.wfl.sampling.dao;


import static org.junit.Assert.*;

import com.wfl.sampling.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @ Author     ：wfl
 * @ Date       ：Created in 14:40 2018/12/20
 * @ Description：
 * @ Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminDaoTest {

    @Autowired
    AdminDao adminDao;

    @Test
    public void queryByAdmin() {
        Admin admin = new Admin();
        admin.setUserName("1037377970@qq.com");
        admin.setPassword("55665566g");
        Admin returnA = adminDao.queryByAdmin(admin);
        System.out.println(returnA.getAddDate());
    }

    @Test
    public void insertAdmin() {
        Admin admin = new Admin();
        admin.setUserName("wangfulin@qq.com");
        admin.setPassword("55665566g");
        admin.setState(0);
        int effectedNum = adminDao.insertAdmin(admin);
        assertEquals(1,effectedNum);
    }

    @Test
    public void updateAdmin() {
        Admin admin = new Admin();
        admin.setUserName("wangfulin@qq.com");
        admin.setPassword("55665566g");
        admin.setUpdateDate(new Date());
        int effectedNum = adminDao.updateAdmin(admin);
        assertEquals(1,effectedNum);
    }

    @Test
    public void hasExisted() {
        Admin admin = new Admin();
        admin.setUserName("1037377970@qq.com");
        Admin result = adminDao.hasExisted(admin);
        System.out.println(result.getUserName());
    }
}