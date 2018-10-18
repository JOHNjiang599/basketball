package org.octopusbaby.basketball.dao;

import org.apache.ibatis.annotations.Param;
import org.octopusbaby.basketball.entity.Admin;

public interface AdminDao {
    /**
     * 添加管理员
     * @param userName
     * @param password
     * @return boolean
     */
    boolean insertAdmin(@Param("userName") String userName,
                        @Param("password") String password);

    /**
     * 获取所有管理员信息
     *
     * @return AllAdmin
     */
    Admin getAllAdmin();

    /**
     * 通过管理员名称获取管理员
     *
     * @param userName
     * @return Admin
     */
    Admin getAdminByName(@Param("userName") String userName);
}
