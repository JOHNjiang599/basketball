package org.octopusbaby.basketball.dao;

import org.apache.ibatis.annotations.Param;
import org.octopusbaby.basketball.entity.Member;

import java.util.List;

public interface MemberDao {

    /**
     * 更改球员为不是首发状态
     *
     * @param isFirst
     * @return
     */
    int toNotIsFirst(@Param("memberId") int memberId,
                     @Param("teamId") int teamId,
                     @Param("isFirst") int isFirst);

    /**
     * 更改球员为是首发状态
     *
     * @param isFirst
     * @return
     */
    int toIsFirst(@Param("memberId") int memberId,
                  @Param("teamId") int teamId,
                  @Param("isFirst") int isFirst);

    /**
     * 添加球员
     * @param memberId
     * @param memberName
     * @param firstStart
     * @return boolean
     */
    int insertMember(@Param("memberId") int memberId,
                     @Param("memberName") String memberName,
                     @Param("firstStart") int firstStart,
                     @Param("teamId")int teamId);

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
     * 通过球员ID和球队ID查询指定球员信息
     *
     * @param memberId
     * @return Member
     */
    Member queryByMIdAndTid(@Param("memberId") int memberId,
                            @Param("teamId")int teamId);

    /**
     * 通过球队ID查询该队的球员信息
     *
     * @return Member
     */
    List<Member> queryByTeamId(@Param("teamId") int teamId);

    /**
     * 通过球员ID删除球员
     *
     * @param memberId
     * @return
     */
    int delByMemberId(@Param("memberId") int memberId,
                          @Param("teamId") int teamId);

    /**
     * 通过球员ID更改球员信息
     *
     * @param memberId
     * @param memberName
     * @param firstStart
     * @return
     */
    int modifyByMemberId(@Param("memberId") int memberId,
                             @Param("memberName") String memberName,
                             @Param("firstStart") int firstStart);

}
