package org.octopusbaby.basketball.dto;

import java.io.Serializable;

public class FirstStarting implements Serializable {
    //球队ID
    private Integer teamId;
    //球员ID
    private Integer memberId;
    //是否首发
    private Integer isFirst;

    public FirstStarting() {
    }

    public FirstStarting(Integer teamId, Integer memberId, Integer isFirst) {
        this.teamId = teamId;
        this.memberId = memberId;
        this.isFirst = isFirst;
    }


    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getIsFirst() {
        return isFirst;
    }

    public void setIsFirst(Integer isFirst) {
        this.isFirst = isFirst;
    }


    @Override
    public String toString() {
        return "FirstStarting{" +
                "teamId=" + teamId +
                ", memberId=" + memberId +
                ", isFirst=" + isFirst +
                '}';
    }
}
