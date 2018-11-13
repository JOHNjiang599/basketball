package org.octopusbaby.basketball.dao;

import org.junit.Test;
import org.octopusbaby.basketball.BaseTest;
import org.octopusbaby.basketball.entity.Match;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 数据访问层测试
 */
public class MatchDaoTest extends BaseTest {

    @Autowired
    private MatchDao matchDao;

    /**
     * 插入一条记录（单参）
     */
    @Test
    public void insert() {
        Match match = new Match();
        match.setTeamId(1);
        //....
        int insert = matchDao.insert(match);
    }

    /**
     * 获取所有比赛信息
     */
    @Test
    public void getAllInfo() {
        List<Match> allInfo = matchDao.getAllInfo();
        for (Match match : allInfo) {
            System.out.println("\n\n" + match + "\n");
        }
    }

    /**
     * 通过球员ID和球队ID获取所有比赛信息
     */
    @Test
    public void getByMIdAndTId() {
        int memberId = 23;
        int teamId = 1;
        List<Match> matches = matchDao.getByMIdAndTId(memberId, teamId);
        for (Match match : matches) {
            System.out.println("\n" + match);
        }
    }

    /**
     * 通过球队ID获取该队所有队员的信息
     */
    @Test
    public void getByTeamId() {
        int teamId = 1;
        List<Match> byTeamId = matchDao.getByTeamId(teamId);
    }

    /**
     * 插入一条记录（多参）
     */
    @Test
    public void insertMatch() {
        int matchSection = 1;
        String matchTime = "12:40";
        int eventType = 2;
        int memberId = 23;
        int teamId = 1;
        int i = matchDao.insertMatch(matchSection, matchTime, eventType, memberId, teamId);
    }

    /**
     * 删除一条记录
     */
    @Test
    public void delMatch() {
        String matchTime = "12:40";
        int eventType = 2;
        int memberId = 23;
        int i = matchDao.delMatch(matchTime, eventType, memberId);
    }

    /**
     * 修改一条记录
     */
    @Test
    public void modifyOneMatch() {
        String matchTime = "12:40";
        int eventType = 0;
        int memberId = 0;
        int i = matchDao.modifyOneMatch(matchTime, eventType, memberId);
    }
}