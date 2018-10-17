package org.octopusbaby.basketball.dao;

import org.apache.ibatis.annotations.Param;

public interface AdminDao {

    boolean addAdmin(@Param("user") String user, @Param("password") String password);
}
