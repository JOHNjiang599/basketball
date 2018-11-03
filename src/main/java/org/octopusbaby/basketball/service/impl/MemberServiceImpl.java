package org.octopusbaby.basketball.service.impl;

import org.octopusbaby.basketball.dao.MemberDao;
import org.octopusbaby.basketball.entity.Member;
import org.octopusbaby.basketball.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 函数说明请看接口
 */
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberDao memberDao;

    @Autowired
    public MemberServiceImpl(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public boolean toNotIsFirst(int memberId, int teamId, int isFirst) {
        return memberDao.toNotIsFirst(memberId, teamId, isFirst);
    }

    @Override
    public boolean toIsFirst(int memberId, int teamId, int isFirst) {
        return memberDao.toIsFirst(memberId, teamId, isFirst);
    }

    @Override
    public boolean addMember(int memberId, String memberName, int firstStart, int teamId) {
        return memberDao.insertMember(memberId, memberName, firstStart, teamId);
    }

    @Override
    public List<Member> gainAllMember() {
        return memberDao.queryAllMember();
    }

    @Override
    public Member gainByMemberId(int memberId) {
        return memberDao.queryByMemberId(memberId);
    }

    @Override
    public Member gainByMIdAndTid(int memberId, int teamId) {
        return memberDao.queryByMIdAndTid(memberId, teamId);
    }

    @Override
    public boolean deleteByMemberId(int memberId, int teamId) {
        return memberDao.delByMemberId(memberId, teamId);
    }

    @Override
    public boolean modifyByMemberId(int memberId, String memberName, int firstStart) {
        return memberDao.modifyByMemberId(memberId, memberName, firstStart);
    }
}
