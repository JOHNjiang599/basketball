package org.octopusbaby.basketball.entity;

import java.io.Serializable;


public class Match implements Serializable {

    private int id;

    private String MatchTime;

    private int EventType;

    private int memberId;

    private int teamId;

    public Match() {
    }

    public Match(int id, String matchTime, int eventType, int memberId, int teamId) {
        this.id = id;
        MatchTime = matchTime;
        EventType = eventType;
        this.memberId = memberId;
        this.teamId = teamId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatchTime() {
        return MatchTime;
    }

    public void setMatchTime(String matchTime) {
        MatchTime = matchTime;
    }

    public int getEventType() {
        return EventType;
    }

    public void setEventType(int eventType) {
        EventType = eventType;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", MatchTime='" + MatchTime + '\'' +
                ", EventType=" + EventType +
                ", memberId=" + memberId +
                ", teamId=" + teamId +
                '}';
    }
}
