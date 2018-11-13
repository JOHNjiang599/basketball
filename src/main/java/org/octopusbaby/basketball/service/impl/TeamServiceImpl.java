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
        if (teamName != null && !"".equals(teamName)) {
            try {
                int insertTeam = teamDao.insertTeam(teamId, teamName);
                if (insertTeam > 0) {
                    return true;
                } else {
                    throw new RuntimeException("添加球队信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加球队信息失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("球队信息不能为空");
        }
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
        if (teamId > 0) {
            try {
                int delCount = teamDao.delByTeamId(teamId);
                if (delCount > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("球队编号要大于0");
        }

    }

    @Override
    public boolean modifyByTeamId(int teamId, String teamName) {
        if (teamName != null && !"".equals(teamName)) {
            try {
                int modCount = teamDao.modifyByTeamId(teamId, teamName);
                if (modCount > 0) {
                    return true;
                } else {
                    throw new RuntimeException("修改失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("修改失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("球队名不能为空");
        }
    }
}
