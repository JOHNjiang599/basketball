package org.octopusbaby.basketball.service;

import org.octopusbaby.basketball.entity.Team;

import java.util.List;

public interface TeamService {

    /**
     * 查询球队关联其球队球员
     *
     * @return
     */
    List<Team> teamWithMember();
    /**
     * 添加球队
     *
     * @param teamId
     * @param teamName
     * @return boolean
     */
    boolean addTeam(int teamId, String teamName);

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
     * @return TeamDTO
     */
    Team gainByTeamId(int teamId);

    /**
     * 通过球队名字查询指定球队
     *
     * @param teamName
     * @return TeamDTO
     */
    Team queryByTeamName(String teamName);

    /**
     * 通过球队ID删除
     *
     * @param teamId
     * @return
     */
    boolean deleteByTeamId(int teamId);

    /**
     * 通过球队ID修改球队名
     *
     * @param teamId
     * @return
     */
    boolean modifyByTeamId(int teamId, String teamName);
}
