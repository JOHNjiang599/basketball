package org.octopusbaby.basketball.dto;

public class TeamAndMember {

    private Integer teamId;

    private String teamName;

    private Integer memberId;

    private String memberName;

    private Integer isFirst;

    public TeamAndMember() {
    }

    public TeamAndMember(Integer teamId, String teamName, Integer memberId, String memberName, Integer isFirst) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.memberId = memberId;
        this.memberName = memberName;
        this.isFirst = isFirst;
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

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Integer getIsFirst() {
        return isFirst;
    }

    public void setIsFirst(Integer isFirst) {
        this.isFirst = isFirst;
    }

    @Override
    public String toString() {
        return "TeamAndMember{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", isFirst=" + isFirst +
                '}';
    }
}
