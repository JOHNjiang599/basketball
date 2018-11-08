package org.octopusbaby.basketball.service;

import org.octopusbaby.basketball.entity.Member;

import java.util.List;

public interface MemberService {

    /**
     * 更改球员为不是首发状态
     *
     * @param isFirst
     * @return
     */
    boolean toNotIsFirst(int memberId, int teamId, int isFirst);

    /**
     * 更改球员为是首发状态
     *
     * @param isFirst
     * @return
     */
    boolean toIsFirst(int memberId, int teamId, int isFirst);


    /**
     * 添加球员
     *
     * @param memberId
     * @param memberName
     * @param firstStart
     * @return boolean
     */
    boolean addMember(int memberId, String memberName, int firstStart,int teamId);

    /**
     * 查询所有球员
     *
     * @return AllMember
     */
    List<Member> gainAllMember();

    /**
     * 通过球员ID查询指定球员信息
     *
     * @param memberId
     * @return Member
     */
    Member gainByMemberId(int memberId);

    /**
     * 通过球队ID查询该队的球员信息
     *
     * @return Member
     */
    List<Member> gainByTeamId(int teamId);

    /**
     * 通过球员ID和球队ID查询指定球员信息
     *
     * @param memberId
     * @return Member
     */
    Member gainByMIdAndTid(int memberId, int teamId);

    /**
     * 通过球员ID删除球员
     *
     * @param memberId
     * @return
     */
    boolean deleteByMemberId(int memberId,int teamId);

    /**
     * 通过球员ID更改球员信息
     *
     * @param memberId
     * @param memberName
     * @param firstStart
     * @return
     */
    boolean modifyByMemberId(int memberId, String memberName, int firstStart);

}
