package org.octopusbaby.basketball.dto;

import java.io.Serializable;

public class HistoryResult implements Serializable {
    //球队ID
    private Integer teamId;
    //球队分数
    private String teamName;
    //球队得分
    private Integer score;

    public HistoryResult() {
    }

    public HistoryResult(Integer teamId, String teamName, Integer score) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.score = score;
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
        this.teamName = teamName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "HistoryResult{" +
                "teamId=" + teamId +
                ", teamName=" + teamName +
                ", score=" + score +
                '}';
    }
}
