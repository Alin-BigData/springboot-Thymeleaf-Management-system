package com.wfl.sampling.service.impl;

import com.wfl.sampling.dao.OrderDao;
import com.wfl.sampling.entity.Order;
import com.wfl.sampling.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    /**
     * 返回所有列表中 的最新信息 相同订单只显示最新的
     */
    @Override
    public List<Order> listAllOrder() {
        return orderDao.queryAllOrder();
    }

    /**
     * 按条件查询
     */
    @Override
    public List<Order> findOrderByCondition(Order order) {
        return orderDao.queryOrderByCondition(order);
    }

    /**
     * 通过前端传过来的订单id号 在数据库中查找
     * 关于该订单的所有处理流信息
     */
    @Override
    public List<Order> findOrderByOrderId(String orderId) {
        if (orderId != null || "".equals(orderId)) {
            try {
                return orderDao.queryOrderByOrderId(orderId);
            } catch (Exception e) {
                throw new RuntimeException("哦哦 出错咯!");
            }
        } else {
            throw new RuntimeException("订单号不能为 空");
        }

    }


    /**
     * to do
     * 修改订单状态
     * 从传过来的订单id号 先去获取该订单的最新的订单信息
     * 之后再去 重新插入一条新的信息订单号不变
     */
    @Override
    public boolean modifyOrderById(Order order) {
        if (order.getOrderId() != null) {
            List<Order> list = orderDao.queryOrderByOrderId(order.getOrderId());
            Order order1 = list.get(0);
            Order order2 = new Order();
            order2.setOrderId(order1.getOrderId());
            order2.setPhoneNum(order1.getPhoneNum());
            order2.setUserName(order1.getUserName());
            order2.setLocation(order1.getLocation());
            order2.setSex(order1.getSex());
            order2.setRegion(order1.getRegion());
            order2.setHandleStatus(order.getHandleStatus());
            order2.setHandleTime(new Date());
            int effectNum = orderDao.insertOrder(order2);
            if (effectNum > 0) {
                return true;
            } else{
                throw new RuntimeException("修改失败");
            }
        }else{
            throw new RuntimeException("订单编好为空");
        }
    }



    @Override
    public boolean addOrder(Order order) {
        if (order.getUserName() != null && !"".equals(order.getUserName()) && order.getPhoneNum() != null) {
            Date time = new Date();
            order.setCreateTime(time);
            order.setHandleTime(time);
            //设定订单号码
            order.setOrderId(getOrderIdByUUId());
            System.out.println("addOrder"+order);
            try{
                int effectedNum = orderDao.insertOrder(order);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("添加订单失败");
                }
            }catch (Exception e){
                throw new RuntimeException("添加订单失败");
            }
        } else {
            throw new RuntimeException("用户名或密码不能为空");
        }
    }

    @Override
    public int countOrder(Order order) {

        List<Order> countOrderList = orderDao.queryOrderByConditionWithoutLimit(order);
        System.out.println(countOrderList);
        return countOrderList.size();
    }

    public String getOrderIdByUUId() {
        Date date = new Date();
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
