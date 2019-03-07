package com.wfl.sampling.service;

import com.wfl.sampling.entity.Admin;

/**
 * @ Author     ：wfl
 * @ Date       ：Created in 15:43 2018/12/20
 * @ Description：
 * @ Modified By：
 */
public interface AdminService {
    Admin findAdmin(Admin admin);

    Admin hasExisted(Admin admin);


    boolean addAdmin(Admin admin);

    boolean modifyAdmin(Admin admin);

}
