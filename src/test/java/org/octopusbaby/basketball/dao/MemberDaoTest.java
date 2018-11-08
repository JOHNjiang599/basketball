package org.octopusbaby.basketball.dao;

import org.junit.Test;
import org.octopusbaby.basketball.BaseTest;
import org.octopusbaby.basketball.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 数据访问层测试
 */
public class MemberDaoTest extends BaseTest {

    @Autowired
    private MemberDao memberDao;

    /**
     * 修改首发状态
     */
    @Test
    public void toNotIsFirst() {
        int memberId = 23;
        int teamId = 1;
        int firstStart = 0;
        int i = memberDao.toNotIsFirst(memberId, teamId, firstStart);
    }

    /**
     * 修改首发状态
     */
    @Test
    public void toIsFirst() {
        int memberId = 23;
        int teamId = 1;
        int firstStart = 1;
        int i = memberDao.toIsFirst(memberId, teamId, firstStart);
    }

    /**
     * 插入一条球员信息
     */
    @Test
    public void insertMember() {
        int memberId = 23;
        String memberName = "john";
        int firstStart = 1;
        int teamId = 1;
        int i = memberDao.insertMember(memberId, memberName, firstStart, teamId);
    }

    /**
     * 获取所有球员信息
     */
    @Test
    public void queryAllMember() {
        List<Member> members = memberDao.queryAllMember();
        for (Member member : members) {
            System.out.println("\n" + member);
        }
    }

    /**
     * 通过球员ID获取球员信息
     */
    @Test
    public void queryByMemberId() {
        int memberId = 1;
        Member member = memberDao.queryByMemberId(memberId);
        System.out.println("\n" + member);
    }

    /**
     * 通过球队ID和球员ID查询
     */
    @Test
    public void queryByMIdAndTid() {
        int teamId = 1;
        int memberId = 23;
        Member member = memberDao.queryByMIdAndTid(memberId, teamId);
    }

    /**
     * 通过球队ID获取球员信息
     */
    @Test
    public void queryByTeamId() {
        int teamId = 1;
        List<Member> memberList = memberDao.queryByTeamId(teamId);
        for (Member member : memberList) {
            System.out.println("\n" + member);
        }
    }

    /**
     * 通过球员ID删除球员信息
     */
    @Test
    public void delByMemberId() {
        int memberId = 1;
        int teamId = 1;
        int i = memberDao.delByMemberId(memberId, teamId);
    }

    /**
     * 通过球员ID修改球员信息
     */
    @Test
    public void modifyByMemberId() {
        int memberId = 1;
        String memberName = "john";
        int firstStart = 1;
        int i = memberDao.modifyByMemberId(memberId, memberName, firstStart);
    }
}