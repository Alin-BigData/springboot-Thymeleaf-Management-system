package com.wfl.sampling.web;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.wfl.sampling.entity.User;
import com.wfl.sampling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：wfl
 * @ Date       ：Created in 10:41 2018/12/19
 * @ Description：
 * @ Modified By：
 */
//ResponseBody + Controller
@RestController
//根路由
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 获取所有的人员列表
     * */
    @RequestMapping(value = "/listuser",method = RequestMethod.GET)
    private Map<String,Object> listArea(){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<User> list = userService.getUsersList();
        modelMap.put("userList",list);
        return modelMap;
    }

    /***
     * 通过名字来模糊查询
     * */
    @RequestMapping(value = "/listuserbyname",method = RequestMethod.GET)
    private Map<String,Object> listUserByName(String name){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<User> list = userService.getUserByName(name);
        modelMap.put("listuserbyname",list);
        return modelMap;
    }

    /***
     * 通过手机号来模糊查询
     * */
    @RequestMapping(value = "/userbyphNum",method = RequestMethod.GET)
    private Map<String,Object> userByPhNum(String phoneNum){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<User> list = userService.getUserByPhoneNum(phoneNum);
        modelMap.put("userbyphNum",list);
        return modelMap;
    }

    /**
     * 添加用户
     * */
    @RequestMapping(value = "/adduser",method = RequestMethod.POST)
    private Map<String,Object> addUser(@RequestBody User user)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String,Object> modelMap = new HashMap<>();
        System.out.println(user);
        modelMap.put("success",userService.addUser(user));
        return modelMap;
    }

    @RequestMapping(value = "modifyuser",method = RequestMethod.POST)
    private Map<String,Object> modifyUser(@RequestBody User user)
            throws JsonParseException, JsonMappingException, IOException{
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改区域信息
        modelMap.put("success", userService.modifyUser(user));
        return modelMap;
    }

    @RequestMapping(value = "/removeuser", method = RequestMethod.GET)
    private Map<String, Object> removeUser(String phoneNum) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改区域信息
        modelMap.put("success", userService.deleteUser(phoneNum));
        return modelMap;
    }

    @RequestMapping(value = "/getpaystatus", method = RequestMethod.GET)
    private Map<String, Object> getPayStatus(String phoneNum){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<User> list = userService.getUserByPhoneNum(phoneNum);
        //返回用户的 支付状态
        modelMap.put("success", list);
        return modelMap;
    }
}
