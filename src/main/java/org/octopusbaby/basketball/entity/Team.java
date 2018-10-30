package org.octopusbaby.basketball.entity;

import java.io.Serializable;

public class Team implements Serializable {

    private Integer teamId;

    private String teamName;

    public Team(Integer teamId, String teamName) {
        this.teamId = teamId;
        this.teamName = teamName;
    }

    public Team() {
        super();
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName == null ? null : teamName.trim();
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}