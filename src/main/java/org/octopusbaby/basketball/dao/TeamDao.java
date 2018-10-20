package org.octopusbaby.basketball.dao;

import org.apache.ibatis.annotations.Param;
import org.octopusbaby.basketball.entity.Team;

public interface TeamDao {
    /**
     * 添加球队
     *
     * @param teamId
     * @param teamName
     * @return boolean
     */
    boolean insertTeam(@Param("teamId") int teamId,
                       @Param("teamName") String teamName);

    /**
     * 查询所有球队
     *
     * @return AllTeam
     */
    Team queryAllTeam();

    /**
     * 通过球队ID查询指定球队
     *
     * @param teamId
     * @return Team
     */
    Team queryByTeamId(int teamId);
}
