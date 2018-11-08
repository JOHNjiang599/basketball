package org.octopusbaby.basketball.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.octopusbaby.basketball.BaseTest;
import org.octopusbaby.basketball.dto.FirstStarting;
import org.octopusbaby.basketball.entity.Member;
import org.octopusbaby.basketball.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务层测试
 */
public class TeamServiceTest extends BaseTest {

    @Autowired
    private TeamService teamService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private MatchService matchService;

    /**
     * 获取某队信息和该队全员信息
     */
    @Test
    public void teamWithMember() {
        List<Team> teamList = teamService.teamWithMember();
        System.out.println("\n" + teamList);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("teams", teamList);
        System.out.println("\n" + jsonObject);
        String str = JSON.toJSONString(jsonObject.toString());
        System.out.println("\n" + str);
    }

    /**
     * 获取首发球员
     */
    @Test
    public void getFirst() {
        List<Member> memberList = memberService.gainAllMember();
        List<FirstStarting> firstList = new ArrayList<>();
        List<FirstStarting> secondList = new ArrayList<>();
        JSONObject jsonObject = new JSONObject();
        for (Member member : memberList) {
            FirstStarting first = new FirstStarting();
            FirstStarting second = new FirstStarting();
            if (1 == member.getTeamId()) {
                if (1 == member.getMemberFirstStart()) {
                    first.setMemberId(member.getMemberId());
                    firstList.add(first);
                }
            }
            if (2 == member.getTeamId()) {
                if (1 == member.getMemberFirstStart()) {
                    second.setMemberId(member.getMemberId());
                    secondList.add(second);
                }
            }

        }
        System.out.println("firstList:" + firstList);
        jsonObject.put("first", firstList);
        jsonObject.put("second", secondList);
        System.out.println("jsonObject:" + jsonObject);
        String s = JSON.toJSONString(jsonObject.toString());
        System.out.println("rs:" + s);
    }

    /**
     * 获取替补球员
     */
    @Test
    public void getNotFirst() {
        List<Member> memberList = memberService.gainAllMember();
        List<FirstStarting> leftMemberList = new ArrayList<>();
        JSONObject jsonObj = new JSONObject();
        for (Member member : memberList) {
            FirstStarting noFirstStarting = new FirstStarting();
            if (1 == member.getTeamId()) {
                if (0 == member.getMemberFirstStart()) {
                    noFirstStarting.setMemberId(member.getMemberId());
                    leftMemberList.add(noFirstStarting);
                }
            }

        }
        System.out.println("noFirstStartList:" + leftMemberList);
        jsonObj.put("noFirstStart", leftMemberList);
        System.out.println("jsonObject:" + jsonObj);
        String noFirstStartJSONString = JSON.toJSONString(jsonObj.toString());
        System.out.println("noFirstStartJSONString:" + noFirstStartJSONString);
    }

    /**
     * 加分，犯规
     */
    @Test
    public void addMatchRecord() {
        int matchSection = 1;
        String matchTime = "12:40";
        int eventType = 3;
        int memberId = 23;
        int teamId = 1;

        int status;
        String operateMsg;
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            operateMsg = "success";
            status = 200;
            boolean operateStatus = matchService.addMatch(matchSection, matchTime, eventType, memberId, teamId);
            if (operateStatus) {
                map.put("operateMsg", operateMsg);
                map.put("status", status);
                map.put("operateStatus", operateStatus);
                System.out.println("success:" + map);
            }
        } catch (Exception e) {
            e.printStackTrace();
            operateMsg = "error";
            status = 404;
            map.put("operateMsg", operateMsg);
            map.put("status", status);
            System.out.println("error" + map);
        }
        String mapString = JSON.toJSONString(map);
        String jsonString = JSON.toJSONString(mapString);
        System.out.println(jsonString);
    }

    /**
     * 换人操作
     */
    @Test
    public void exchangeMember() {
        int teamId = 1;
        int firstMemberId = 23;
        int secMemberId = 22;
        JSONObject jsonObject = new JSONObject();
        /*更改根据被换下场的球员编号、球员所在队伍编号查询出的队员的上场状态*/
        boolean firstStatus = memberService.toNotIsFirst(firstMemberId, teamId, 0);
        /*更改选择上场的球员球员编号、球员所在队伍编号查询出的队员的上场状态*/
        boolean secStatus = memberService.toIsFirst(secMemberId, teamId, 1);
        if (firstStatus && secStatus) {
            jsonObject.put("status", "exchangeMemberSuccess");
            System.out.println(jsonObject);
        } else {
            jsonObject.put("status", "exchangeMemberFail");
            System.out.println(jsonObject);
        }
        String jsonString = JSON.toJSONString(jsonObject.toString());
        System.out.println(jsonString);
    }

    /**
     * 添加球队
     */
    @Test
    public void addTeam() {
        int teamId = 1;
        String teamName = "baby";
        boolean b = teamService.addTeam(teamId, teamName);
    }

    /**
     * 获取所有球队信息
     */
    @Test
    public void gainAllTeam() {
        List<Team> teams = teamService.gainAllTeam();
        for (Team team : teams) {
            System.out.println("\n" + team);
        }
    }

    /**
     * 通过球队ID获取球队信息
     */
    @Test
    public void gainByTeamId() {
        int teamId = 2;
        Team team = teamService.gainByTeamId(teamId);
        System.out.println("\n" + team);
    }

    @Test
    public void queryByTeamName() {
        String teamName = "";
        Team team = teamService.queryByTeamName(teamName);
    }

    /**
     * 通过球队ID删除球队信息
     */
    @Test
    public void deleteByTeamId() {
        int teamId = 1;
        boolean b = teamService.deleteByTeamId(teamId);
    }

    /**
     * 通过球队ID修改球队信息
     */
    @Test
    public void modifyByTeamId() {
        int teamId = 1;
        String teamName = "baby";
        boolean b = teamService.modifyByTeamId(teamId, teamName);
    }
}