package com.wfl.sampling.web;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.wfl.sampling.entity.Order;
import com.wfl.sampling.handler.PageUtil;
import com.wfl.sampling.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 添加订单
     */
    @ResponseBody
    @RequestMapping(value = "/addorder", method = RequestMethod.POST)
    private Map<String, Object> addUser(@RequestBody Order order)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<>();
        System.out.println(order);
        modelMap.put("success", orderService.addOrder(order));
        return modelMap;
    }

    @RequestMapping("/admin/orderManage_{pageCurrent}_{pageSize}_{pageCount}")
    public String newsManage(Order order, @PathVariable Integer pageCurrent, @PathVariable Integer pageSize, @PathVariable Integer pageCount, Model model){
        //判断 页数
        if (pageSize == 0) pageSize = 10;
        if (pageCurrent == 0) pageCurrent = 1;
        if("".equals(order.getUserName())){
            order.setUserName(null);
        }
        if("".equals(order.getPhoneNum())){
            order.setPhoneNum(null);
        }
        int rows = orderService.countOrder(order);
        if (pageCount == 0) pageCount = rows % pageSize == 0 ? (rows / pageSize) : (rows / pageSize) + 1;

        //查询
        order.setStart((pageCurrent - 1) * pageSize);
        order.setEnd(pageSize);

        List<Order> orders = orderService.findOrderByCondition(order);

        //输出
        model.addAttribute("orders", orders);
        String pageHTML = PageUtil.getPageContent("orderManage_{pageCurrent}_{pageSize}_{pageCount}", pageCurrent, pageSize, pageCount);
        System.out.println(pageHTML);
        model.addAttribute("pageHTML", pageHTML);
        return "order/orderManage";
    }

    @RequestMapping(value = "/admin/orderDetail")
    private String orderDetail(Order order, Model model) {
        String orderId = order.getOrderId();
        List<Order> orders = orderService.findOrderByOrderId(orderId);
        model.addAttribute("orders", orders);
        return "order/orderDetail";
    }
    @RequestMapping(value = "/admin/orderHandle")
    private String orderHandle(Order order, Model model) {
        String orderId = order.getOrderId();
        List<Order> orders = orderService.findOrderByOrderId(orderId);
        model.addAttribute("orders", orders);
        return "order/orderHandle";
    }

}
