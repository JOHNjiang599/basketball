package org.octopusbaby.basketball.entity;

import java.io.Serializable;

public class Member implements Serializable {
    //球员ID
    private Integer memberId;
    //球员名称
    private String memberName;
    //球员是否是首发
    private Integer memberFirstStart;
    //球员所属球队ID
    private Integer teamId;

    public Member(Integer memberId, String memberName, Integer memberFirstStart, Integer teamId) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberFirstStart = memberFirstStart;
        this.teamId = teamId;
    }

    public Member() {
        super();
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
        this.memberName = memberName == null ? null : memberName.trim();
    }

    public Integer getMemberFirstStart() {
        return memberFirstStart;
    }

    public void setMemberFirstStart(Integer memberFirstStart) {
        this.memberFirstStart = memberFirstStart;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", memberFirstStart=" + memberFirstStart +
                ", teamId=" + teamId +
                '}';
    }
}