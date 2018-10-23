package org.octopusbaby.basketball.entity;

import java.io.Serializable;


public class Member implements Serializable {

    private int memberId;//球员编号，即球衣号

    private String memberName;//球员名称

    private String firstStart;//是否首发

    public Member() {
    }

    public Member(int memberId, String memberName, String firstStart) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.firstStart = firstStart;
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

    public String isFirstStart() {
        return firstStart;
    }

    public void setFirstStart(String firstStart) {
        this.firstStart = firstStart;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", firstStart=" + firstStart +
                '}';
    }
}
