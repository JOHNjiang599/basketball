package org.octopusbaby.basketball.dao;

import org.apache.ibatis.annotations.Param;
import org.octopusbaby.basketball.entity.Member;

import java.util.List;

public interface MemberDao {

    /**
     * 添加球员
     * @param memberId
     * @param memberName
     * @param firstStart
     * @return boolean
     */
    boolean insertMember(@Param("memberId") int memberId,
                         @Param("memberName") String memberName,
                         @Param("firstStart") String firstStart);

    /**
     * 查询所有球员
     * @return AllMember
     */
    List<Member> queryAllMember();

    /**
     * 通过球员ID查询指定球员信息
     * @param memberId
     * @return Member
     */
    Member queryByMemberId(@Param("memberId") int memberId);

    /**
     * 通过球员ID删除球员
     *
     * @param memberId
     * @return
     */
    boolean delByMemberId(@Param("memberId") int memberId);

    /**
     * 通过球员ID更改球员信息
     *
     * @param memberId
     * @param memberName
     * @param firstStart
     * @return
     */
    boolean modifyByMemberId(@Param("memberId") int memberId,
                             @Param("memberName") String memberName,
                             @Param("firstStart") String firstStart);

}
