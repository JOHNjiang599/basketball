package org.octopusbaby.basketball.entity;

public class Member {

    private int memberId;//球员编号，即球衣号

    private String memberName;//球员名称

    private boolean firstStart;//是否首发

    private int teamId;//球队编号

    public Member() {
    }

    public Member(int memberId, String memberName, boolean firstStart, int teamId) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.firstStart = firstStart;
        this.teamId = teamId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public boolean isFirstStart() {
        return firstStart;
    }

    public void setFirstStart(boolean firstStart) {
        this.firstStart = firstStart;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", firstStart=" + firstStart +
                ", teamId=" + teamId +
                '}';
    }
}
