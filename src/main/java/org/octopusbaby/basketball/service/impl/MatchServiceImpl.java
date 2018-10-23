package org.octopusbaby.basketball.service.impl;

import org.octopusbaby.basketball.dao.MatchDao;
import org.octopusbaby.basketball.entity.Match;
import org.octopusbaby.basketball.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private final MatchDao matchDao;

    @Autowired
    public MatchServiceImpl(MatchDao matchDao) {
        this.matchDao = matchDao;
    }

    @Override
    public List<Match> gainAllInfo() {
        return matchDao.getAllInfo();
    }

    @Override
    public Match gainByMIdAndTId(int memberId, int teamId) {
        return matchDao.getByMIdAndTId(memberId, teamId);
    }

    @Override
    public boolean addMatch(String matchTime, int eventType, int memberId, int teamId) {
        return matchDao.insertMatch(matchTime, eventType, memberId, teamId);
    }

    @Override
    public boolean deleteMatch(String matchTime, int eventType, int memberId) {
        return matchDao.delMatch(matchTime, eventType, memberId);
    }

    @Override
    public boolean modifyOneMatch(String matchTime, int eventType, int memberId) {
        return matchDao.modifyOneMatch(matchTime, eventType, memberId);
    }
}
