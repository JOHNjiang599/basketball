package org.octopusbaby.basketball.dao;

import org.apache.ibatis.annotations.Param;

public interface AdminDao {
    /**
     * 添加管理员
     *
     * @param user
     * @param password
     * @return
     */
    boolean addAdmin(@Param("user") String user, @Param("password") String password);


}
