package org.octopusbaby.basketball.entity;

public class Team {

    private int teamId;//球队编号

    private String teamName;//球队名称

    private String teamLoginName;//球队登录名

    private String teamPassword;//球队登录密码

    public Team() {
    }

    public Team(int teamId, String teamName, String teamLoginName, String teamPassword) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamLoginName = teamLoginName;
        this.teamPassword = teamPassword;
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

    public String getTeamLoginName() {
        return teamLoginName;
    }

    public void setTeamLoginName(String teamLoginName) {
        this.teamLoginName = teamLoginName;
    }

    public String getTeamPassword() {
        return teamPassword;
    }

    public void setTeamPassword(String teamPassword) {
        this.teamPassword = teamPassword;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", teamLoginName='" + teamLoginName + '\'' +
                ", teamPassword='" + teamPassword + '\'' +
                '}';
    }
}
