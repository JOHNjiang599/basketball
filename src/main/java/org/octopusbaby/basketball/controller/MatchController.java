package org.octopusbaby.basketball.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.octopusbaby.basketball.dto.FirstStarting;
import org.octopusbaby.basketball.dto.SwapMember;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/match")
public class MatchController {

    private final TeamService teamService;

    private final MemberService memberService;

    private final MatchService matchService;

    @Autowired
    public MatchController(TeamService teamService, MemberService memberService, MatchService matchService) {
        this.teamService = teamService;
        this.memberService = memberService;
        this.matchService = matchService;
    }

    /**
     * 同时获取两队的所有首发和替补
     */
    @ResponseBody
    @RequestMapping(value = "/getteamfirst", method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    public String getTeamFirstAndNoFirst(Integer teamIdA, Integer teamIdB) {
        Map<String, Object> modelMap = new HashMap<>();
        List<Member> firstMembers = memberService.gainByTeamId(teamIdA);
        List<Member> secMembers = memberService.gainByTeamId(teamIdB);
        modelMap.put("firstTeam", firstMembers);
        modelMap.put("secTeam", secMembers);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("teams", modelMap);
        return JSON.toJSONString(jsonObject.toString());
    }

    /**
     * 同时获取某队所有首发和替补
     *
     * @param teamId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getmembers", method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    public String getFirstAndNotFirst(Integer teamId) {
        /*response.setHeader("Content-Type"," application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");*/
        List<Member> members = memberService.gainByTeamId(teamId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("members", members);
        /* System.out.println("\n" + jsonObject);*/
        return JSON.toJSONString(jsonObject.toString());
    }

    /*加分方式：
     * 前台点击球员加分操作后返回加的分值(1,2,3)、球员编号、球员所在队伍编号、得分时刻（节+时刻）
     * 犯规处理方式：
     * 前台点击球员编号，点击犯规操作返回犯规值0、球员编号、球员所在队伍编号、犯规时刻（节+时刻）
     * 返回操作状态
     */
    /**
     * 加分，犯规的操作
     * 添加一条比赛记录
     * @param match
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addmatch", method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    public String addMatchRecord(Match match) {
        //插入记录
        boolean status = matchService.addOneMatch(match);
        JSONObject jsonObject = new JSONObject();
        if (status) {
            jsonObject.put("status", true);
        } else {
            jsonObject.put("status", false);
        }
        return JSON.toJSONString(jsonObject.toString());
    }




    /*换人处理方式：
     * 前端发出换人请求
     * 后端返回不是首发的所有球员编号，前端接收并显示
     * 前端选择上场球员并发出请求
     * 请求包含被换的球员编号、球员所在队伍编号，选择的球员球员编号、球员所在队伍编号两组数据
     * 后台更改更改被换球员和被选择的球员首发状态值
     * 返回操作状态
     */
    /**
     * 传入球员所在队伍编号、被换下场的球员编号、将上场的球员球员编号
     * 进行更改首发状态，达到换人目的
     * @param swapMember
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/exchangemember", method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    public String exchangeMember(SwapMember swapMember) {
        Map<String, Object> modelMap = new HashMap<>();
        /*更改根据被换下场的球员编号、球员所在队伍编号查询出的队员的上场状态*/
        boolean firstStatus = memberService.toNotIsFirst(
                swapMember.getFirstMemberId(), swapMember.getTeamId(), 0);
        /*更改将上场的球员球员编号、球员所在队伍编号查询出的队员的上场状态*/
        boolean secStatus = memberService.toIsFirst(
                swapMember.getSecMemberId(), swapMember.getTeamId(), 1);
        if (firstStatus && secStatus) {
            modelMap.put("status", true);
        } else {
            modelMap.put("status", false);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", modelMap);
        return JSON.toJSONString(jsonObject.toString());
    }

    /**
     * 接受前端请求，返回所有球队信息（包括该队球员）
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getall", method = RequestMethod.GET,
            produces = "application/json;charset=utf-8")
    public String getTeamWithMember() {
        //获取队伍列表（包括属于该队的所有球员）
        List<Team> teamList = teamService.teamWithMember();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("teams", teamList);//封装成JSON对象
        /*System.out.println(JSON.toJSONString(jsonObject.toString()));*/
        return JSON.toJSONString(jsonObject.toString());
    }


    /**
     * 请求带参，说明比赛队伍编号（1、2、3、4、....）
     *
     * @param firstTeam
     * @param secondTeam
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getfirst", method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    public String getFirst(int firstTeam, int secondTeam) {
        //获取所有球员（不分队的）
        List<Member> memberList = memberService.gainAllMember();
        List<FirstStarting> firstList = new ArrayList<>();
        List<FirstStarting> secondList = new ArrayList<>();
        JSONObject jsonObject = new JSONObject();
        for (Member member : memberList) {
            FirstStarting first = new FirstStarting();
            FirstStarting second = new FirstStarting();
            if (firstTeam == member.getTeamId()) {//判断是否请求的球队ID
                if (1 == member.getMemberFirstStart()) {//判断是否首发
                    first.setMemberId(member.getMemberId());
                    firstList.add(first);
                }
            }
            if (secondTeam == member.getTeamId()) {
                if (1 == member.getMemberFirstStart()) {
                    second.setMemberId(member.getMemberId());
                    secondList.add(second);
                }
            }
        }
        //封装成JSON对象
        jsonObject.put("first", firstList);
        jsonObject.put("second", secondList);
        /*System.out.println("jsonObject:" + jsonObject);*/
        return JSON.toJSONString(jsonObject.toString());
    }

    /*返回某队替补队员编号*/

    /**
     * 根据球队编号返回该队的替补
     *
     * @param teamId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getnotfirst", method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    public String getNotFirst(int teamId) {
        //获取所有球员
        List<Member> memberList = memberService.gainAllMember();
        List<FirstStarting> leftMemberList = new ArrayList<>();
        JSONObject jsonObj = new JSONObject();
        for (Member member : memberList) {
            FirstStarting noFirstStarting = new FirstStarting();
            if (teamId == member.getTeamId()) {//判断是否属于请求的球队
                if (0 == member.getMemberFirstStart()) {//判断是否不是首发
                    noFirstStarting.setMemberId(member.getMemberId());
                    leftMemberList.add(noFirstStarting);
                }
            }
        }
        jsonObj.put("noFirstStart", leftMemberList);
        /*System.out.println("jsonObject:" + jsonObj);*/
        return JSON.toJSONString(jsonObj.toString());
    }
}
