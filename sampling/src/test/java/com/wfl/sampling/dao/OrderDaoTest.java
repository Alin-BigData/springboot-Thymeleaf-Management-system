package com.wfl.sampling.dao;

import com.wfl.sampling.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDaoTest {

    @Autowired
    private OrderDao orderDao;
    @Test
    public void queryAllOrder() {
        List<Order> list = orderDao.queryAllOrder();
        System.out.println(list);
    }

    @Test
    public void queryOrderByCondition() {
        Order order = new Order();
        order.setPhoneNum("13124123124");
        order.setPaperStatus(1);
        //order.setUserName("xiao");
        List<Order> list = orderDao.queryOrderByConditionWithoutLimit(order);
        System.out.println(list);
    }

    @Test
    public void queryOrderByOrderId() {
        List<Order> list = orderDao.queryOrderByOrderId("1");
        System.out.println(list);
    }

    @Test
    public void updateOrderById() {
        List<Order> list = orderDao.queryOrderByOrderId("2018122500270932936");
        Order order = list.get(0);
        Order order1 = new Order();
        order1.setOrderId(order.getOrderId());
        order1.setPhoneNum(order.getPhoneNum());
        order1.setUserName(order.getUserName());
        order1.setLocation(order.getLocation());
        order1.setSex(order.getSex());
        order1.setRegion(order.getRegion());
        order1.setHandleStatus(2);
        order1.setHandleTime(new Date());
        orderDao.insertOrder(order1);
    }

    @Test
    public void insertOrder(){
        Order order = new Order();
        order.setUserName("wangfulin");
        order.setPhoneNum("15759206413");
        order.setOrderId(getOrderIdByUUId());
        order.setCreateTime(new Date());
        order.setSex("男");
        order.setRegion("xiamen");
        order.setLocation("xxii");
        int effectNum = orderDao.insertOrder(order);
        assertEquals(1,effectNum);
    }

    public  String getOrderIdByUUId() {
        Date date=new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        String time = format.format(date);
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return time + String.format("%011d", hashCodeV);
    }

}