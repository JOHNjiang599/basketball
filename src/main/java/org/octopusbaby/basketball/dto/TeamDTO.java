package org.octopusbaby.basketball.dto;

import java.io.Serializable;


public class TeamDTO implements Serializable {

    private int teamId;//球队编号

    private String teamName;//球队名称

    public TeamDTO() {
    }

    public TeamDTO(int teamId, String teamName) {
        this.teamId = teamId;
        this.teamName = teamName;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
