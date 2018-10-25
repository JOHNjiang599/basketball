package org.octopusbaby.basketball.service;

import org.octopusbaby.basketball.entity.Match;

import java.util.List;

public interface MatchService {

    /**
     * 获取所有对战信息
     *
     * @return AllMatch
     */
    List<Match> gainAllInfo();

    /**
     * 通过球员ID和球队ID查询某条记录记录
     *
     * @param memberId
     * @param teamId
     * @return Match
     */
    Match gainByMIdAndTId(int memberId, int teamId);

    /**
     * 添加一条对战记录
     *
     * @param matchTime 比赛时刻,字符串,格式   分:秒
     * @param eventType 事件类型 0犯规，1加一分，2加两分，3加三分
     * @param memberId
     * @param teamId
     * @return boolean
     */
    boolean addMatch(String matchTime, int eventType, int memberId, int teamId);

    /**
     * 通过时刻、事件类型和球员ID删除一条记录
     *
     * @param matchTime
     * @param eventType
     * @param memberId
     * @return
     */
    boolean deleteMatch(String matchTime, int eventType, int memberId);

    /**
     * 通过球员ID修改他的一条记录
     *
     * @param matchTime
     * @param eventType
     * @param memberId
     * @return
     */
    boolean modifyOneMatch(String matchTime, int eventType, int memberId);
}
