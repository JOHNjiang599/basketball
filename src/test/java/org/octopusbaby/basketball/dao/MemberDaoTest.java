package org.octopusbaby.basketball.dao;

import org.junit.Test;
import org.octopusbaby.basketball.BaseTest;
import org.octopusbaby.basketball.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberDaoTest extends BaseTest {

    @Autowired
    private MemberDao memberDao;

    @Test
    public void testQueryAllMember() {
        Member member = memberDao.queryAllMember();
        System.out.println("\n\n" + member + "\n");
    }

    @Test
    public void testQueryById() {
        int memberId = 1;
        Member member = memberDao.queryById(memberId);
        System.out.println("\n\n" + member + "\n");
    }
}
