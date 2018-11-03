package org.octopusbaby.basketball.entity;

import java.io.Serializable;
import java.util.List;

public class Team implements Serializable {
    //球队ID
    private Integer teamId;
    //球队名称
    private String teamName;
    //属于该球队的球员列表
    private List<Member> memberList;

    public Team(Integer teamId, String teamName, List<Member> memberList) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.memberList = memberList;
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

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", memberList=" + memberList +
                '}';
    }
}