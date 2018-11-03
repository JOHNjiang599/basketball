package org.octopusbaby.basketball.dao;

import org.apache.ibatis.annotations.Param;
import org.octopusbaby.basketball.entity.Team;

import java.util.List;

public interface TeamDao {
    /**
     * 查询球队关联其球队球员
     * @return
     */
    List<Team> teamWithMember();

    /**
     * 添加球队
     * @param teamId
     * @param teamName
     * @return boolean
     */
    boolean insertTeam(@Param("teamId") int teamId,
                       @Param("teamName") String teamName);

    /**
     * 查询所有球队
     * @return AllTeam
     */
    List<Team> queryAllTeam();

    /**
     * 通过球队ID查询指定球队
     * @param teamId
     * @return TeamDTO
     */
    Team queryByTeamId(@Param("teamId") int teamId);

    /**
     * 通过球队名字查询指定球队
     *
     * @param teamName
     * @return TeamDTO
     */
    Team queryByTeamName(@Param("teamName") String teamName);

    /**
     * 通过球队ID删除
     *
     * @param teamId
     * @return
     */
    boolean delByTeamId(@Param("teamId") int teamId);

    /**
     * 通过球队ID修改球队名
     *
     * @param teamId
     * @return
     */
    boolean modifyByTeamId(@Param("teamId") int teamId,
                           @Param("teamName") String teamName);
}
