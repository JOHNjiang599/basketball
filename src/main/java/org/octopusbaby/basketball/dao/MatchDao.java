package org.octopusbaby.basketball.dao;

import org.apache.ibatis.annotations.Param;
import org.octopusbaby.basketball.entity.Match;

public interface MatchDao {
    /**
     * 获取所有对战信息
     *
     * @return AllMatch
     */
    Match getAllInfo();

    /**
     * 通过球员ID和球队ID查询某条记录记录
     *
     * @param memberId
     * @param teamId
     * @return Match
     */
    Match getByMIdAndTId(@Param("memberId") int memberId,
                         @Param("teamId") int teamId);

    /**
     * 添加一条对战记录
     *
     * @param matchTime 比赛时刻,字符串,格式   分:秒
     * @param eventType 事件类型 0犯规，1加一分，2加两分，3加三分
     * @param memberId
     * @param teamId
     * @return boolean
     */
    boolean insertMatch(@Param("match_time") String matchTime,
                        @Param("event_type") int eventType,
                        @Param("memberId") int memberId,
                        @Param("teamId") int teamId);

    boolean updateMatchInfo();

    /**
     * 通过时刻、事件类型和球员ID删除一条记录
     *
     * @param matchTime
     * @param eventType
     * @param memberId
     * @return
     */
    void deleteMatch(@Param("match_time") String matchTime,
                     @Param("event_type") int eventType,
                     @Param("memberId") int memberId);
}
