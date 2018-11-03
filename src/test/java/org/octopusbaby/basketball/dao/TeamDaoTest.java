package org.octopusbaby.basketball.dao;

import org.junit.Test;
import org.octopusbaby.basketball.BaseTest;
import org.octopusbaby.basketball.entity.Member;
import org.octopusbaby.basketball.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeamDaoTest extends BaseTest {

    @Autowired
    private TeamDao teamDao;

    /**
     * 数据访问层测试
     * 获取带有球员信息的球队信息
     */
    @Test
    public void testFindWithMember() {
        List<Team> teamWithMember = teamDao.teamWithMember();
        for (Team team : teamWithMember) {
            System.out.println("\n" + team + "\n");
            List<Member> members = team.getMemberList();
            for (Member m : members) {
                System.out.println("\n" + m);
            }
        }
    }

    /**
     * 数据访问层测试
     * 插入一条球队信息
     */
    @Test
    public void testInsertTeam() {
        int teamId = 1;
        String teamName = "baby";
        boolean b = teamDao.insertTeam(teamId, teamName);
        if (b) {
            System.out.println("\n" + "成功添加一条数据");
        }
    }

    /**
     * 数据访问层测试
     * 获取所有球队信息
     */
    @Test
    public void testQueryAllTeam() {
        List<Team> teams = teamDao.queryAllTeam();
        for (Team team : teams) {
            System.out.println("\n" + team);
        }
    }

    /**
     * 数据访问层测试
     * 通过球队ID获取球队信息
     */
    @Test
    public void testQueryByTeamId() {
        int teamId = 2;
        Team team = teamDao.queryByTeamId(teamId);
        System.out.println("\n" + team);
    }

    /**
     * 数据访问层测试
     * 通过球队ID删除球队信息
     */
    @Test
    public void testDelByTeamId() {
        int teamId = 1;
        boolean b = teamDao.delByTeamId(teamId);
    }

    /**
     * 数据访问层测试
     * 通过球队ID修改球队信息
     */
    @Test
    public void testModifyByTeamId() {
        int teamId = 1;
        String teamName = "baby";
        boolean b = teamDao.modifyByTeamId(teamId, teamName);
    }
}
