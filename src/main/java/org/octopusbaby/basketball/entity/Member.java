package org.octopusbaby.basketball.entity;

import java.io.Serializable;

public class Member implements Serializable {
    private Integer memberId;

    private String memberName;

    private Integer memberFirstStart;

    public Member(Integer memberId, String memberName, Integer memberFirstStart) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberFirstStart = memberFirstStart;
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

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", memberFirstStart=" + memberFirstStart +
                '}';
    }
}