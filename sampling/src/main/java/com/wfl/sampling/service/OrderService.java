package com.wfl.sampling.service;

import com.wfl.sampling.entity.Order;

import java.util.List;

public interface OrderService {
    /**
     * 默认情况下列出所有的订单
     * 分页，每页默认显示20条，可修改每页显示的数量，按填表时间降序排序。
     * 列表项显示如下：
     * 1、手机号
     * 2、姓名
     * 3、性别
     * 4、出生日期
     * 5、电子邮箱
     * 6、检测项目
     * 7、是否需要纸质报告
     * 8、支付状态
     * 9、处理状态
     * 应该是订单的最新状态才对
     * @return
     */
    List<Order> listAllOrder();


    /**
     * 可按以下几个维度进行筛选查找（多个条件的查找为“与”操作）：
     * 1、填表日期范围
     * 2、手机号码（精确搜索）
     * 3、姓名（可模糊匹配）
     * 4、是否需要纸单（下拉框）
     * 5、支付状态（选择需要纸单时出现）
     * 6、处理状态（待处理、处理中、已处理、已作废）
     *
     * 初始化进入页面时，所有条件为空，即按填表日期降序排序显示全部。
     */

    List<Order> findOrderByCondition(Order order);

    List<Order> findOrderByOrderId(String orderId);

    /**
     * 更新该订单的状态
     * 先通过订单编号寻找到这个订单的最新状态的id
     * 然后通过id去修改订单状态
     * */
    boolean modifyOrderById(Order order);

    boolean addOrder(Order order);

    int countOrder(Order order);
}
