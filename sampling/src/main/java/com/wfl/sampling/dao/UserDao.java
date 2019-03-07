package com.wfl.sampling.dao;


import com.wfl.sampling.entity.User;

import java.util.List;

/**
 * @ Author     ：wfl
 * @ Date       ：Created in 15:54 2018/12/18
 * @ Description：
 * @ Modified By：
 */
public interface UserDao {
    /**
     * 获取所有订单
    **/
    List<User> queryUsers();
    /**
     * 通过手机号查询
     * */
    List<User> queryUserByPhoneNum(String phoneNum);
    /**
     * 用过姓名模糊查询
     * */
    List<User> queryUserByName(String userName);



    /**
     * 对成员的增删改
     * */
    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(String phoneNum);


}
