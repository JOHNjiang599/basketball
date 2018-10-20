package org.octopusbaby.basketball.dao;

import org.apache.ibatis.annotations.Param;
import org.octopusbaby.basketball.entity.Member;

public interface MemberDao {

    /**
     * 添加球员
     *
     * @param memberId
     * @param memberName
     * @param firstStart
     * @return boolean
     */
    boolean insertMember(@Param("memberId") int memberId,
                         @Param("memberName") String memberName,
                         @Param("firstStart") boolean firstStart);

    /**
     * 查询所有球员
     *
     * @return AllMember
     */
    Member queryAllMember();//查询所有球员信息

    /**
     * 通过球员ID查询指定球员信息
     *
     * @param memberId
     * @return Member
     */
    Member queryByMemberId(@Param("memberId") int memberId);//查询指定球员信息
}
