package com.wfl.sampling.service.impl;

import com.wfl.sampling.dao.AdminDao;
import com.wfl.sampling.entity.Admin;
import com.wfl.sampling.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ Author     ：wfl
 * @ Date       ：Created in 15:44 2018/12/20
 * @ Description：
 * @ Modified By：
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;

    @Override
    public Admin findAdmin(Admin admin) {
        return adminDao.queryByAdmin(admin);
    }

    @Override
    public Admin hasExisted(Admin admin) {
        return adminDao.hasExisted(admin);
    }

    @Override
    public boolean addAdmin(Admin admin) {
        if(admin.getUserName()!=null && !"".equals(admin.getUserName()) && admin.getPassword()!=null){
            admin.setAddDate(new Date());
            try{
                int effectedNum = adminDao.insertAdmin(admin);
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

    @Override
    public boolean modifyAdmin(Admin admin) {
        if(admin.getUserName()!=null){
            admin.setUpdateDate(new Date());
            try{
                int effectedNum = adminDao.updateAdmin(admin);
                if(effectedNum>0){
                    return true;
                }else {
                    throw new RuntimeException("更新人员信息失败!");
                }
            }catch (Exception e) {
                throw new RuntimeException("更新人员信息失败:" + e.toString());
            }
        }else {
            throw new RuntimeException("手机号不能为空！");
        }
    }


}
