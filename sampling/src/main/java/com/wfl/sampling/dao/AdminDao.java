package com.wfl.sampling.dao;

import com.wfl.sampling.entity.Admin;

/**
 * @ Author     ：wfl
 * @ Date       ：Created in 14:12 2018/12/20
 * @ Description：
 * @ Modified By：
 */

public interface AdminDao {
    /**
     * 查询是否有该用户
     * */
    Admin queryByAdmin(Admin admin);

    Admin hasExisted(Admin admin);

    int insertAdmin(Admin admin);

    int updateAdmin(Admin admin);



}
