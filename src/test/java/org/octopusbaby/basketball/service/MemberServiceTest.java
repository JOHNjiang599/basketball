package org.octopusbaby.basketball.service;

import org.junit.Test;
import org.octopusbaby.basketball.BaseTest;
import org.octopusbaby.basketball.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MemberServiceTest extends BaseTest {

    @Autowired
    private MemberService memberService;

    /**
     * 业务层测试
     * 修改首发状态
     */
    @Test
    public void testToNotIsFirst() {
        int memberId = 23;
        int teamId = 1;
        int firstStart = 0;
        boolean b = memberService.toNotIsFirst(memberId, teamId, firstStart);
        if (b) {
            System.out.println("\n修改成功\n");
        } else {
            System.out.println("\n修改失败\n");
        }

    }

    /**
     * 业务层测试
     * 修改首发状态
     */
    @Test
    public void teatToIsFirst() {
        int memberId = 23;
        int teamId = 1;
        int firstStart = 1;
        boolean b = memberService.toIsFirst(memberId, teamId, firstStart);
        if (b) {
            System.out.println("\n修改成功\n");
        } else {
            System.out.println("\n修改失败\n");
        }

    }

    /**
     * 业务层测试
     * 添加一条球员信息
     */
    @Test
    public void testAddMember() {
        int memberId = 23;
        String memberName = "john";
        int firstStart = 1;
        int teamId = 1;
        boolean b = memberService.addMember(memberId, memberName, firstStart, teamId);
    }

    /**
     * 业务层测试
     * 获取所有球员信息
     */
    @Test
    public void testGainAllMember() {
        List<Member> members = memberService.gainAllMember();
        for (Member member : members) {
            System.out.println("\n" + member);
        }
    }

    /**
     * 业务层测试
     * 通过球员ID获取球员信息
     */
    @Test
    public void testGainByMemberId() {
        int memberId = 1;
        Member member = memberService.gainByMemberId(memberId);
        System.out.println("\n" + member);
    }

    /**
     * 业务层测试
     * 通过球员ID删除球员信息
     */
    @Test
    public void testDeleteByMemberId() {
        int memberId = 23;
        int teamId = 1;
        boolean b = memberService.deleteByMemberId(memberId, teamId);
    }

    /**
     * 业务层测试
     * 通过球员ID修改球员信息
     */
    @Test
    public void testModifyByMemberId() {
        int memberId = 1;
        String memberName = "john";
        int firstStart = 1;
        boolean b = memberService.modifyByMemberId(memberId, memberName, firstStart);
    }
}
