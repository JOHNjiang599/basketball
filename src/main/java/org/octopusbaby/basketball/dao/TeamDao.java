package org.octopusbaby.basketball.dao;

import org.octopusbaby.basketball.entity.Team;

public interface TeamDao {

    boolean addTeam();

    Team queryAllTeam();//查询所有球队信息

    Team findById(int teamId);//查询指定球队信息
}
