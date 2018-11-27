package org.octopusbaby.basketball.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.octopusbaby.basketball.dto.HistoryResult;
import org.octopusbaby.basketball.dto.TeamAndMember;
import org.octopusbaby.basketball.entity.Match;
import org.octopusbaby.basketball.entity.Member;
import org.octopusbaby.basketball.entity.Team;
import org.octopusbaby.basketball.service.MatchService;
import org.octopusbaby.basketball.service.MemberService;
import org.octopusbaby.basketball.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/team")
public class TeamController {

    private final TeamService teamService;

    private final MemberService memberService;

    private final MatchService matchService;

    @Autowired
    public TeamController(TeamService teamService, MemberService memberService, MatchService matchService) {
        this.teamService = teamService;
        this.memberService = memberService;
        this.matchService = matchService;
    }

    @ResponseBody
    @RequestMapping(value = "/addmember", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    public String addMember(Member member) {
        boolean status = memberService.addMember(member.getMemberId(), member.getMemberName(),
                member.getMemberFirstStart(), member.getTeamId());
        JSONObject jsonObject = new JSONObject();
        if (status) {
            jsonObject.put("status", true);
        } else {
            jsonObject.put("status", false);
        }
        /*System.out.println(jsonObject);*/
        return JSON.toJSONString(jsonObject.toString());
    }

    @ResponseBody
    @RequestMapping(value = "/modifymember", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    public String modifyMember(Member member) {
        boolean status = memberService.modifyByMemberId(member.getMemberId(),
                member.getMemberName(), member.getMemberFirstStart());
        JSONObject jsonObject = new JSONObject();
        if (status) {
            jsonObject.put("status", true);
        } else {
            jsonObject.put("status", false);
        }
        /*System.out.println(jsonObject);*/
        return JSON.toJSONString(jsonObject.toString());
    }


    @ResponseBody
    @RequestMapping(value = "/deletemember", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    public String deleteMember(Integer teamId, Integer memberId) {
        boolean status = memberService.deleteById(memberId, teamId);
        JSONObject jsonObject = new JSONObject();
        if (status) {
            jsonObject.put("status", true);
        } else {
            jsonObject.put("status", false);
        }
        return JSON.toJSONString(jsonObject.toString());
    }

    @ResponseBody
    @RequestMapping(value = "/gainmembers", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    public String gainMembers(String name) {
        /*System.out.println("teamName:"+name);*/
        Team team = teamService.queryByTeamName(name);
        List<Member> memberList = memberService.gainByTeamId(team.getTeamId());
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("team", team);
        modelMap.put("memberList", memberList);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("teamInfo", modelMap);
        return JSON.toJSONString(jsonObject.toString());
    }

    /**
     * 获取所有球队信息
     */
    @ResponseBody
    @RequestMapping(value = "/getteams", method = RequestMethod.GET,
            produces = "application/json; charset=utf-8")
    public String gainAllTeam() {
        List<Team> teams = teamService.gainAllTeam();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("teamList", teams);
        /*System.out.println("\n" + jsonObject);*/
        return JSON.toJSONString(jsonObject.toString());
    }

    /**
     * 添加球队队伍
     * @param teamAndMember
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addateam")
    public String addTeamAndMember(TeamAndMember teamAndMember) {
        Map<String, Object> modelMap = new HashMap<>();
        //添加队伍
        boolean addTeamStatus = teamService.addTeam(
                teamAndMember.getTeamId(), teamAndMember.getTeamName());
        boolean addMemberStatus = memberService.addMember(
                teamAndMember.getMemberId(), teamAndMember.getMemberName(),
                teamAndMember.getIsFirst(), teamAndMember.getTeamId());
        //设置返回状态
        if (addTeamStatus && addMemberStatus) {
            modelMap.put("status", true);
        } else {
            modelMap.put("status", false);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", modelMap);
        return JSON.toJSONString(jsonObject.toString());
    }
    /**
     * 通过两个队的ID来获取两队之间的比赛记录
     *
     * @param firstTeamId
     * @param secTeamId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/gethistorybyid")
    public String getHistoryById(int firstTeamId, int secTeamId) {
        //通过球队ID获取比赛记录
        List<Match> firstMatches = matchService.gainByTeamId(firstTeamId);
        List<Match> secMatches = matchService.gainByTeamId(secTeamId);
        //通过球队ID获取球队信息
        Team firstTeam = teamService.gainByTeamId(firstTeamId);
        Team secTeam = teamService.gainByTeamId(secTeamId);
        //初始化分数
        int firstTeamScore = 0;
        int secTeamScore = 0;
        //统计分数
        for (Match firstMatch : firstMatches) {
            firstTeamScore += firstMatch.getEventType();
        }
        for (Match secMatch : secMatches) {
            secTeamScore += secMatch.getEventType();
        }
        //将球队ID，球队名字，球队总得分封装成对象
        HistoryResult firstHistoryResult = new HistoryResult();//一队
        firstHistoryResult.setTeamId(firstTeam.getTeamId());
        firstHistoryResult.setTeamName(firstTeam.getTeamName());
        firstHistoryResult.setScore(firstTeamScore);

        HistoryResult secHistoryResult = new HistoryResult();//二队
        secHistoryResult.setTeamId(secTeam.getTeamId());
        secHistoryResult.setTeamName(secTeam.getTeamName());
        secHistoryResult.setScore(secTeamScore);
        //将球队ID，球队名字，球队总得分封装成JSON对象
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstTeamScore", firstHistoryResult);
        jsonObject.put("secTeamScore", secHistoryResult);
        /*System.out.println("\n jsonObject:" + jsonObject);*/
        //返回球队ID，球队名字，球队总得分JSON字符串
        return JSON.toJSONString(jsonObject.toString());
    }


    /**
     * 通过两个队的名称来获取两队之间的比赛记录
     * 实质是通过ID获取
     *
     * @param firstTeamName
     * @param secTeamName
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/gethistorybyname")
    public String getHistoryByName(String firstTeamName, String secTeamName) {
        //通过球队名称获取球队信息
        Team firstTeam = teamService.queryByTeamName(firstTeamName);
        Team secTeam = teamService.queryByTeamName(secTeamName);
        //通过球队ID获取比赛记录
        List<Match> firstMatches = matchService.gainByTeamId(firstTeam.getTeamId());
        List<Match> secMatches = matchService.gainByTeamId(secTeam.getTeamId());
        //初始化分数
        int firstTeamScore = 0;
        int secTeamScore = 0;
        //统计分数
        for (Match firstMatch : firstMatches) {
            firstTeamScore += firstMatch.getEventType();
        }
        for (Match secMatch : secMatches) {
            secTeamScore += secMatch.getEventType();
        }
        //将球队ID，球队名字，球队总得分封装成对象
        HistoryResult firstHistoryResult = new HistoryResult();//一队
        firstHistoryResult.setTeamId(firstTeam.getTeamId());
        firstHistoryResult.setTeamName(firstTeam.getTeamName());
        firstHistoryResult.setScore(firstTeamScore);

        HistoryResult secHistoryResult = new HistoryResult();//二队
        secHistoryResult.setTeamId(secTeam.getTeamId());
        secHistoryResult.setTeamName(secTeam.getTeamName());
        secHistoryResult.setScore(secTeamScore);
        //将球队ID，球队名字，球队总得分封装成JSON对象
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstTeamScore", firstHistoryResult);
        jsonObject.put("secTeamScore", secHistoryResult);
        /*System.out.println("\n jsonObject:" + jsonObject);*/
        //返回球队ID，球队名字，球队总得分JSON字符串
        return JSON.toJSONString(jsonObject.toString());
    }
}
