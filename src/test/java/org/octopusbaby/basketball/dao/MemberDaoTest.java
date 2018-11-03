package org.octopusbaby.basketball.dao;

import org.junit.Test;
import org.octopusbaby.basketball.BaseTest;
import org.octopusbaby.basketball.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MemberDaoTest extends BaseTest {

    @Autowired
    private MemberDao memberDao;

    /**
     * 数据访问层测试
     * 修改首发状态
     */
    @Test
    public void testToNotIsFirst() {
        int memberId = 23;
        int teamId = 1;
        int firstStart = 0;
        boolean b = memberDao.toNotIsFirst(memberId, teamId, firstStart);
        if (b) {
            System.out.println("\n修改成功\n");
        } else {
            System.out.println("\n修改失败\n");
        }

    }

    /**
     * 数据访问层测试
     * 修改首发状态
     */
    @Test
    public void teatToIsFirst() {
        int memberId = 23;
        int teamId = 1;
        int firstStart = 1;
        boolean b = memberDao.toIsFirst(memberId, teamId, firstStart);
        if (b) {
            System.out.println("\n修改成功\n");
        } else {
            System.out.println("\n修改失败\n");
        }

    }

    /**
     * 数据访问层测试
     * 插入一条球员信息
     */
    @Test
    public void testInsertMember() {
        int memberId = 23;
        String memberName = "john";
        int firstStart = 1;
        int teamId = 1;
        boolean b = memberDao.insertMember(memberId, memberName, firstStart, teamId);
    }

    /**
     * 数据访问层测试
     * 获取所有球员信息
     */
    @Test
    public void testQueryAllMember() {
        List<Member> members = memberDao.queryAllMember();
        for (Member member : members) {
            System.out.println("\n" + member);
        }
    }

    /**
     * 数据访问层测试
     * 通过球员ID获取球员信息
     */
    @Test
    public void testQueryByMemberId() {
        int memberId = 1;
        Member member = memberDao.queryByMemberId(memberId);
        System.out.println("\n" + member);
    }

    /**
     * 数据访问层测试
     * 通过球员ID删除球员信息
     */
    @Test
    public void testDelByMemberId() {
        int memberId = 1;
        int teamId = 1;
        boolean b = memberDao.delByMemberId(memberId, teamId);
    }

    /**
     * 数据访问层测试
     * 通过球员ID修改球员信息
     */
    @Test
    public void testModifyByMemberId() {
        int memberId = 1;
        String memberName = "john";
        int firstStart = 1;
        boolean b = memberDao.modifyByMemberId(memberId, memberName, firstStart);
    }
}
