package org.octopusbaby.basketball.service.impl;

import org.octopusbaby.basketball.dao.TeamDao;
import org.octopusbaby.basketball.entity.Team;
import org.octopusbaby.basketball.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamDao teamDao;

    @Autowired
    public TeamServiceImpl(TeamDao teamDao) {
        this.teamDao = teamDao;
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
    public boolean deleteByTeamId(int teamId) {
        return teamDao.delByTeamId(teamId);
    }

    @Override
    public boolean modifyByTeamId(int teamId, String teamName) {
        return teamDao.modifyByTeamId(teamId, teamName);
    }
}
