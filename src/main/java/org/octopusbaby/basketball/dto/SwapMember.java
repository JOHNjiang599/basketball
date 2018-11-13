package org.octopusbaby.basketball.dto;

public class SwapMember {

    private Integer teamId;

    private Integer firstMemberId;

    private Integer secMemberId;

    public SwapMember() {
    }

    public SwapMember(Integer teamId, Integer firstMemberId, Integer secMemberId) {
        this.teamId = teamId;
        this.firstMemberId = firstMemberId;
        this.secMemberId = secMemberId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getFirstMemberId() {
        return firstMemberId;
    }

    public void setFirstMemberId(Integer firstMemberId) {
        this.firstMemberId = firstMemberId;
    }

    public Integer getSecMemberId() {
        return secMemberId;
    }

    public void setSecMemberId(Integer secMemberId) {
        this.secMemberId = secMemberId;
    }

    @Override
    public String toString() {
        return "SwapMember{" +
                "teamId=" + teamId +
                ", firstMemberId=" + firstMemberId +
                ", secMemberId=" + secMemberId +
                '}';
    }
}
