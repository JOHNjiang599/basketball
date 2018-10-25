package org.octopusbaby.basketball.service;

import org.octopusbaby.basketball.entity.Member;

import java.util.List;

public interface MemberService {

    /**
     * 添加球员
     *
     * @param memberId
     * @param memberName
     * @param firstStart
     * @return boolean
     */
    boolean addMember(int memberId, String memberName, String firstStart);

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
     * 通过球员ID删除球员
     *
     * @param memberId
     * @return
     */
    boolean deleteByMemberId(int memberId);

    /**
     * 通过球员ID更改球员信息
     *
     * @param memberId
     * @param memberName
     * @param firstStart
     * @return
     */
    boolean modifyByMemberId(int memberId, String memberName, String firstStart);

}
