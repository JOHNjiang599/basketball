package org.octopusbaby.basketball.service;

import org.junit.Test;
import org.octopusbaby.basketball.BaseTest;
import org.octopusbaby.basketball.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeamServiceTest extends BaseTest {

    @Autowired
    private TeamService teamService;

    @Test
    public void testAddTeam() {
        int teamId = 1;
        String teamName = "baby";
        boolean b = teamService.addTeam(teamId, teamName);
        if (b) {
            System.out.println("\n" + "成功添加一条数据");
        }
    }

    @Test
    public void testGainAllTeam() {
        List<Team> teams = teamService.gainAllTeam();
        for (Team team : teams) {
            System.out.println("\n" + team);
        }
    }

    @Test
    public void testGainByTeamId() {
        int teamId = 2;
        Team team = teamService.gainByTeamId(teamId);
        System.out.println("\n" + team);
    }

    @Test
    public void testDeleteByTeamId() {
        int teamId = 1;
        boolean b = teamService.deleteByTeamId(teamId);
    }

    @Test
    public void testModifyByTeamId() {
        int teamId = 1;
        String teamName = "baby";
        boolean b = teamService.modifyByTeamId(teamId, teamName);
    }
}
