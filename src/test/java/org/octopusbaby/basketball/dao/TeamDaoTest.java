package org.octopusbaby.basketball.dao;

import org.junit.Test;
import org.octopusbaby.basketball.BaseTest;
import org.octopusbaby.basketball.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 数据访问层测试
 */
public class TeamDaoTest extends BaseTest {

    @Autowired
    private TeamDao teamDao;

    /**
     * 获取带有球员信息的球队信息
     */
    @Test
    public void teamWithMember() {
    }

    /**
     * 插入一条球队信息
     */
    @Test
    public void insertTeam() {
        int teamId = 1;
        String teamName = "baby";
        int insertTeam = teamDao.insertTeam(teamId, teamName);
    }

    /**
     * 获取所有球队信息
     */
    @Test
    public void queryAllTeam() {
        List<Team> teams = teamDao.queryAllTeam();
        for (Team team : teams) {
            System.out.println("\n" + team);
        }
    }

    /**
     * 通过球队ID获取球队信息
     */
    @Test
    public void queryByTeamId() {
        int teamId = 1;
        Team team = teamDao.queryByTeamId(teamId);
        System.out.println("\n" + team);
    }

    /**
     * 通过球队名称获取球队信息
     */
    @Test
    public void queryByTeamName() {
        String teamName = "";
        Team team = teamDao.queryByTeamName(teamName);
    }

    /**
     * 通过球队ID删除球队信息
     */
    @Test
    public void delByTeamId() {
        int teamId = 1;
        int byTeamId = teamDao.delByTeamId(teamId);
    }

    /**
     * 通过球队ID修改球队信息
     */
    @Test
    public void modifyByTeamId() {
        int teamId = 1;
        String teamName = "baby";
        int modify = teamDao.modifyByTeamId(teamId, teamName);
    }
}