package org.octopusbaby.basketball.dao;

import org.junit.Test;
import org.octopusbaby.basketball.BaseTest;
import org.octopusbaby.basketball.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;

public class TeamDaoTest extends BaseTest {

    @Autowired
    private TeamDao teamDao;

    @Test
    public void testQueryAllTeam() {
        Team team = teamDao.queryAllTeam();
        System.out.println("\n\n" + team + "\n");
    }

    @Test
    public void testFindById() {
        int teamId = 2;
        Team team = teamDao.findById(teamId);
        System.out.println("\n\n" + team + "\n");
    }
}
