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
        if (memberId > 0) {
            if (teamId > 0) {
                if (isFirst == 1 || isFirst == 0) {
                    try {
                        int count = memberDao.toNotIsFirst(memberId, teamId, isFirst);
                        if (count > 0) {
                            return true;
                        } else {
                            throw new RuntimeException("修改首发状态失败");
                        }
                    } catch (Exception e) {
                        throw new RuntimeException("修改首发状态失败" + e.getMessage());
                    }
                } else {
                    throw new RuntimeException("首发状态值只能为0或1");
                }
            } else {
                throw new RuntimeException("球队编号不能为负数");
            }
        } else {
            throw new RuntimeException("球衣号不能为负数");
        }
    }

    @Override
    public boolean toIsFirst(int memberId, int teamId, int isFirst) {
        if (memberId > 0) {
            if (teamId > 0) {
                if (isFirst == 1 || isFirst == 0) {
                    try {
                        int count = memberDao.toIsFirst(memberId, teamId, isFirst);
                        if (count > 0) {
                            return true;
                        } else {
                            throw new RuntimeException("修改首发状态失败");
                        }
                    } catch (Exception e) {
                        throw new RuntimeException("修改首发状态失败" + e.getMessage());
                    }
                } else {
                    throw new RuntimeException("首发状态值只能为0或1");
                }
            } else {
                throw new RuntimeException("球队编号不能为负数");
            }
        } else {
            throw new RuntimeException("球衣号不能为负数");
        }
    }

    @Override
    public boolean addMember(int memberId, String memberName, int firstStart, int teamId) {
        if (memberId > 0) {
            if (memberName != null && !"".equals(memberName)) {
                try {
                    int addCount = memberDao.insertMember(memberId, memberName, firstStart, teamId);
                    if (addCount > 0) {
                        return true;
                    } else {
                        throw new RuntimeException("添加球员失败");
                    }
                } catch (Exception e) {
                    throw new RuntimeException("添加球员失败" + e.getMessage());
                }
            } else {
                throw new RuntimeException("球员名不能为空");
            }
        } else {
            throw new RuntimeException("球衣号不能为负数");
        }

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
    public List<Member> gainByTeamId(int teamId) {
        return memberDao.queryByTeamId(teamId);
    }

    @Override
    public Member gainByMIdAndTid(int memberId, int teamId) {
        return memberDao.queryByMIdAndTid(memberId, teamId);
    }

    @Override
    public boolean deleteById(int memberId, int teamId) {
        if (memberId > 0) {
            if (teamId > 0) {
                int delCount = memberDao.delById(memberId, teamId);
                if (delCount > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除失败");
                }
            } else {
                throw new RuntimeException("球队编号不能为负数");
            }
        } else {
            throw new RuntimeException("球衣号不能为负数");
        }
    }

    @Override
    public boolean modifyByMemberId(int memberId, String memberName, int firstStart) {
        int modCount = memberDao.modifyByMemberId(memberId, memberName, firstStart);
        if (modCount > 0) {
            return true;
        } else {
            throw new RuntimeException("修改失败");
        }
    }
}
