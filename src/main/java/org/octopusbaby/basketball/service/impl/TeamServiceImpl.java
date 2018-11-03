package org.octopusbaby.basketball.service.impl;

import org.octopusbaby.basketball.dao.TeamDao;
import org.octopusbaby.basketball.entity.Team;
import org.octopusbaby.basketball.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 函数说明请看接口
 */
@Service
public class TeamServiceImpl implements TeamService {

    private final TeamDao teamDao;

    @Autowired
    public TeamServiceImpl(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    @Override
    public List<Team> teamWithMember() {
        return teamDao.teamWithMember();
    }

    @Override
    public boolean addTeam(int teamId, String teamName) {
        return teamDao.insertTeam(teamId, teamName);
    }

    @Override
    public List<Team> gainAllTeam() {
        return teamDao.queryAllTeam();
    }

    @Override
    public Team gainByTeamId(int teamId) {
        return teamDao.queryByTeamId(teamId);
    }

    @Override
    public Team queryByTeamName(String teamName) {
        return teamDao.queryByTeamName(teamName);
    }

    @Override
    public boolean deleteByTeamId(int teamId) {
        return teamDao.delByTeamId(teamId);
    }

    @Override
    public boolean modifyByTeamId(int teamId, String teamName) {
        return teamDao.modifyByTeamId(teamId, teamName);
    }
}
