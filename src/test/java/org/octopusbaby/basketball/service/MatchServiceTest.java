package org.octopusbaby.basketball.service;

import org.junit.Test;
import org.octopusbaby.basketball.BaseTest;
import org.octopusbaby.basketball.entity.Match;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MatchServiceTest extends BaseTest {

    @Autowired
    private MatchService matchService;

    @Test
    public void testGainAllInfo() {
        List<Match> matches = matchService.gainAllInfo();
        for (Match match : matches) {
            System.out.println("\n" + match);
        }
    }

    @Test
    public void testGainByMIdAndTId() {
        int memberId = 23;
        int teamId = 1;
        Match match = matchService.gainByMIdAndTId(memberId, teamId);
        System.out.println("\n" + match);
    }

    @Test
    public void testAddMatch() {
        String matchTime = "12:40";
        int eventType = 2;
        int memberId = 23;
        int teamId = 1;
        boolean b = matchService.addMatch(matchTime, eventType, memberId, teamId);
        if (b) {
            System.out.println("\n\n" + "成功添加一条对站记录" + "\n");
        }
    }


    @Test
    public void testDeleteMatch() {
        String matchTime = "12:40";
        int eventType = 2;
        int memberId = 23;
        boolean b = matchService.deleteMatch(matchTime, eventType, memberId);
    }

    @Test
    public void testModifyOneMatch() {
        String matchTime = "12:40";
        int eventType = 0;
        int memberId = 0;
        boolean b = matchService.modifyOneMatch(matchTime, eventType, memberId);
    }
}
