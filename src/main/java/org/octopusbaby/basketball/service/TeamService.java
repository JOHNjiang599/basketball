package org.octopusbaby.basketball.service;

import org.apache.ibatis.annotations.Param;
import org.octopusbaby.basketball.entity.Team;

import java.util.List;

public interface TeamService {

    /**
     * 添加球队
     *
     * @param teamId
     * @param teamName
     * @return boolean
     */
    boolean addTeam(@Param("teamId") int teamId,
                    @Param("teamName") String teamName);

    /**
     * 查询所有球队
     *
     * @return AllTeam
     */
    List<Team> gainAllTeam();

    /**
     * 通过球队ID查询指定球队
     *
     * @param teamId
     * @return Team
     */
    Team gainByTeamId(@Param("teamId") int teamId);

    /**
     * 通过球队ID删除
     *
     * @param teamId
     * @return
     */
    boolean deleteByTeamId(@Param("teamId") int teamId);

    /**
     * 通过球队ID修改球队名
     *
     * @param teamId
     * @return
     */
    boolean modifyByTeamId(@Param("teamId") int teamId,
                           @Param("teamName") String teamName);
}
