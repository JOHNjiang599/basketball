package org.octopusbaby.basketball.dao;

import org.junit.Test;
import org.octopusbaby.basketball.BaseTest;
import org.octopusbaby.basketball.entity.Match;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MatchDaoTest extends BaseTest {

    @Autowired
    private MatchDao matchDao;

    @Test
    public void testGetAllInfo() {
        List<Match> allInfo = matchDao.getAllInfo();
        for (Match match : allInfo) {
            System.out.println("\n\n" + match + "\n");
        }
    }

    @Test
    public void testGetByMIdAndTId() {
        int memberId = 23;
        int teamId = 1;
        Match match = matchDao.getByMIdAndTId(memberId, teamId);
        System.out.println("\n\n" + match + "\n");
    }

    @Test
    public void testInsertMatch() {
        int matchSection = 1;
        String matchTime = "12:40";
        int eventType = 2;
        int memberId = 23;
        int teamId = 1;
        boolean b = matchDao.insertMatch(matchSection, matchTime, eventType, memberId, teamId);
        if (b) {
            System.out.println("\n\n" + "成功添加一条对站记录" + "\n");
        }
    }

    @Test
    public void testDelMatch() {
        String matchTime = "12:40";
        int eventType = 2;
        int memberId = 23;
        boolean b = matchDao.delMatch(matchTime, eventType, memberId);
    }

    @Test
    public void testModifyOneMatch() {
        String matchTime = "12:40";
        int eventType = 0;
        int memberId = 0;
        boolean b = matchDao.modifyOneMatch(matchTime, eventType, memberId);
    }
}
