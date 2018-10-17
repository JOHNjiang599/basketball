package org.octopusbaby.basketball.dao;

import org.octopusbaby.basketball.entity.Member;

public interface MemberDao {

    Member queryAllMember();//查询所有球员信息

    Member queryById(int memberId);//查询指定球员信息
}
