package org.octopusbaby.basketball.service;

import org.junit.Test;
import org.octopusbaby.basketball.BaseTest;
import org.octopusbaby.basketball.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务层测试
 */
public class MemberServiceTest extends BaseTest {

    @Autowired
    private MemberService memberService;

    /**
     * 同时获取某队所有首发和替补
     */
    @Test
    public void getFirstAndNoFirst() {
        Integer teamId = 1;
        Map<String, Object> modelMap = new HashMap<>();
        List<Member> members = memberService.gainByTeamId(teamId);
        modelMap.put("members", members);
        System.out.println(modelMap);
    }

    /**
     * 修改首发状态
     */
    @Test
    public void toNotIsFirst() {
        int memberId = 23;
        int teamId = 1;
        int firstStart = 0;
        boolean b = memberService.toNotIsFirst(memberId, teamId, firstStart);
    }

    /**
     * 修改首发状态
     */
    @Test
    public void toIsFirst() {
        int memberId = 23;
        int teamId = 1;
        int firstStart = 1;
        boolean b = memberService.toIsFirst(memberId, teamId, firstStart);
    }

    /**
     * 添加一条球员信息
     */
    @Test
    public void addMember() {
        int memberId = 23;
        String memberName = "john";
        int firstStart = 1;
        int teamId = 1;
        boolean b = memberService.addMember(memberId, memberName, firstStart, teamId);
    }

    /**
     * 获取所有球员信息
     */
    @Test
    public void gainAllMember() {
        List<Member> members = memberService.gainAllMember();
        for (Member member : members) {
            System.out.println("\n" + member);
        }
    }

    /**
     * 通过球员ID获取球员信息
     */
    @Test
    public void gainByMemberId() {
        int memberId = 1;
        Member member = memberService.gainByMemberId(memberId);
        System.out.println("\n" + member);
    }

    /**
     * 通过球队ID查询该队的球员信息
     */
    @Test
    public void gainByTeamId() {
        int teamId = 1;
        List<Member> memberList = memberService.gainByTeamId(teamId);
        for (Member member : memberList) {
            System.out.println("\n" + member);
        }
    }

    /**
     * 通过球队ID和球员ID查询
     */
    @Test
    public void gainByMIdAndTid() {
        int teamId = 1;
        int memberId = 23;
        Member member = memberService.gainByMIdAndTid(memberId, teamId);
    }

    /**
     * 通过球员ID删除球员信息
     */
    @Test
    public void deleteByMemberId() {
        int memberId = 23;
        int teamId = 1;
        boolean b = memberService.deleteByMemberId(memberId, teamId);
    }

    /**
     * 通过球员ID修改球员信息
     */
    @Test
    public void modifyByMemberId() {
        int memberId = 1;
        String memberName = "john";
        int firstStart = 1;
        boolean b = memberService.modifyByMemberId(memberId, memberName, firstStart);
    }
}