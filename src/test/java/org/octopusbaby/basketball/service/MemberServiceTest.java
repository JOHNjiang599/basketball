package org.octopusbaby.basketball.service;

import org.junit.Test;
import org.octopusbaby.basketball.BaseTest;
import org.octopusbaby.basketball.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MemberServiceTest extends BaseTest {

    @Autowired
    private MemberService memberService;

    @Test
    public void testAddMember() {
        int memberId = 23;
        String memberName = "john";
        String firstStart = "是";
        boolean b = memberService.addMember(memberId, memberName, firstStart);
    }

    @Test
    public void testGainAllMember() {
        List<Member> members = memberService.gainAllMember();
        for (Member member : members) {
            System.out.println("\n" + member);
        }
    }

    @Test
    public void testGainByMemberId() {
        int memberId = 1;
        Member member = memberService.gainByMemberId(memberId);
        System.out.println("\n" + member);
    }

    @Test
    public void testDeleteByMemberId() {
        int memberId = 1;
        boolean b = memberService.deleteByMemberId(memberId);
    }

    @Test
    public void testModifyByMemberId() {
        int memberId = 1;
        String memberName = "john";
        String firstStart = "是";
        boolean b = memberService.modifyByMemberId(memberId, memberName, firstStart);
    }
}
