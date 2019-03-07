package com.wfl.sampling.service;

import com.wfl.sampling.dao.OrderDao;
import com.wfl.sampling.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @ Author     ：wfl
 * @ Date       ：Created in 16:47 2018/12/26
 * @ Description：
 * @ Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {
    @Autowired
    private OrderDao orderDao;
    @Test
    public void countOrder() {
        Order order = new Order();
        order.setId(null);
        order.setOrderId(null);
        order.setUserName("xiao");
        order.setSex(null);
        order.setBirthday(null);
        order.setEmail(null);
        order.setLocation(null);
        order.setRegion(null);
        order.setPaperStatus(0);
        order.setProjectType(null);
        order.setPhoneNum(null);
        order.setPayStatus(0);
        order.setPaperStatus(1);
        order.setHandleStatus(0);


        System.out.println(orderDao.queryOrderByConditionWithoutLimit(order));
    }
}