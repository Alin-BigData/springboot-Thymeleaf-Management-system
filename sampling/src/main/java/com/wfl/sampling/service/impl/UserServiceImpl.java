package com.wfl.sampling.service.impl;

import com.wfl.sampling.dao.UserDao;
import com.wfl.sampling.entity.User;
import com.wfl.sampling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @ Author     ：wfl
 * @ Date       ：Created in 10:20 2018/12/19
 * @ Description：
 * @ Modified By：
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getUsersList() {
        return userDao.queryUsers();
    }

    @Override
    public List<User> getUserByPhoneNum(String phoneNum) {
        return userDao.queryUserByPhoneNum(phoneNum);
    }

    @Override
    public List<User> getUserByName(String UserName) {
        return userDao.queryUserByName(UserName);
    }

    @Transactional
    @Override
    public boolean addUser(User user) {
        if((user.getUserName() != null) && !"".equals(user.getUserName())){
            user.setCreateTime(new Date());
            try{
                int effectedNum = userDao.insertUser(user);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("添加人员信息失败!");
                }
            }catch (Exception e){
                throw new RuntimeException("添加人员信息失败:" + e.toString());
            }
        }else{
            throw new RuntimeException("姓名信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean modifyUser(User user) {
        if(user.getPhoneNum()!=null){
            try{
                // 更新区域信息
                int effectedNum = userDao.updateUser(user);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新人员信息失败!");
                }
            }catch (Exception e) {
                throw new RuntimeException("更新人员信息失败:" + e.toString());
            }
        }else {
            throw new RuntimeException("手机号不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean deleteUser(String phoneNum) {
        if(!"".equals(phoneNum)){
            try{
                int effectedNum = userDao.deleteUser(phoneNum);
                if(effectedNum > 0){
                    return true;
                }else{
                    throw new RuntimeException("删除信息失败!");
                }
            }catch (Exception e) {
                throw new RuntimeException("删除信息失败:" + e.toString());
            }
        }else {
            throw new RuntimeException("手机号不能为空！");
        }
    }
}
