package org.octopusbaby.basketball.dao;

import org.junit.Test;
import org.octopusbaby.basketball.BaseTest;
import org.octopusbaby.basketball.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;

public class TeamDaoTest extends BaseTest {

    @Autowired
    private TeamDao teamDao;

    @Test
    public void testInsertTeam() {
        boolean b = teamDao.insertTeam(1, "章鱼bady");
        if (b) {
            System.out.println("\n\n" + "成功添加一条数据" + "\n");
        }
    }

    @Test
    public void testQueryAllTeam() {
        Team team = teamDao.queryAllTeam();
        System.out.println("\n\n" + team + "\n");
    }

    @Test
    public void testQueryByTeamId() {
        int teamId = 2;
        Team team = teamDao.queryByTeamId(teamId);
        System.out.println("\n\n" + team + "\n");
    }
}
