package org.octopusbaby.basketball.service.impl;

import org.octopusbaby.basketball.dao.MatchDao;
import org.octopusbaby.basketball.entity.Match;
import org.octopusbaby.basketball.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 函数说明看接口
 */
@Service
public class MatchServiceImpl implements MatchService {

    private final MatchDao matchDao;

    @Autowired
    public MatchServiceImpl(MatchDao matchDao) {
        this.matchDao = matchDao;
    }

    @Override
    public boolean addOneMatch(Match match) {
        try {
            int insert = matchDao.insert(match);
            if (insert > 0) {
                return true;
            } else {
                throw new RuntimeException("添加记录失败");
            }
        } catch (Exception e) {
            throw new RuntimeException("添加记录失败" + e.getMessage());
        }
    }

    @Override
    public List<Match> gainAllInfo() {
        return matchDao.getAllInfo();
    }

    @Override
    public List<Match> gainByMIdAndTId(int memberId, int teamId) {
        return matchDao.getByMIdAndTId(memberId, teamId);
    }

    @Override
    public List<Match> gainByTeamId(int teamId) {
        return matchDao.getByTeamId(teamId);
    }

    @Override
    public boolean addMatch(int matchSection, String matchTime, int eventType, int memberId, int teamId) {
        try {
            int addCount = matchDao.insertMatch(matchSection, matchTime, eventType, memberId, teamId);
            if (addCount > 0) {
                return true;
            } else {
                throw new RuntimeException("添加记录失败");
            }
        } catch (Exception e) {
            throw new RuntimeException("添加记录失败" + e.getMessage());
        }
    }

    @Override
    public boolean deleteMatch(String matchTime, int eventType, int memberId) {
        try {
            int count = matchDao.delMatch(matchTime, eventType, memberId);
            if (count > 0) {
                return true;
            } else {
                throw new RuntimeException("删除记录失败");
            }
        } catch (Exception e) {
            throw new RuntimeException("删除记录失败" + e.getMessage());
        }
    }

    @Override
    public boolean modifyOneMatch(String matchTime, int eventType, int memberId) {
        try {
            int count = matchDao.modifyOneMatch(matchTime, eventType, memberId);
            if (count > 0) {
                return true;
            } else {
                throw new RuntimeException("修改记录失败");
            }
        } catch (Exception e) {
            throw new RuntimeException("修改记录失败" + e.getMessage());
        }
    }
}
