package org.octopusbaby.basketball.service.impl;

import org.octopusbaby.basketball.dao.MemberDao;
import org.octopusbaby.basketball.entity.Member;
import org.octopusbaby.basketball.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberDao memberDao;

    @Autowired
    public MemberServiceImpl(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public boolean addMember(int memberId, String memberName, String firstStart) {
        return memberDao.insertMember(memberId, memberName, firstStart);
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
    public boolean deleteByMemberId(int memberId) {
        return memberDao.delByMemberId(memberId);
    }

    @Override
    public boolean modifyByMemberId(int memberId, String memberName, String firstStart) {
        return memberDao.modifyByMemberId(memberId, memberName, firstStart);
    }
}
