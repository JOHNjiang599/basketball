package org.octopusbaby.basketball.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.octopusbaby.basketball.dto.FirstStarting;
import org.octopusbaby.basketball.entity.Member;
import org.octopusbaby.basketball.entity.Team;
import org.octopusbaby.basketball.service.MatchService;
import org.octopusbaby.basketball.service.MemberService;
import org.octopusbaby.basketball.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理管理登录登录之后的请求
 */
@Controller
@RequestMapping("match")
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


    /*初始化一场比赛，接受前端请求，查询球队填写的首发阵容并返回*/

    /**
     * 初始化一场比赛
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("initOneMatch")
    public String initOneMatch() {
        //获取队伍列表（包括属于该队的所有球员）
        List<Team> teamList = teamService.teamWithMember();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("teamsWithMember", teamList);//封装成JSON对象
        System.out.println(JSON.toJSONString(jsonObject.toString()));
        return JSON.toJSONString(jsonObject.toString());
    }


    /*处理加分、犯规、换人请求*/

    /*返回首发队伍队员编号*/

    /**
     * 请求带参，说明比赛队伍编号（1、2、3、4、....）
     *
     * @param firstTeam
     * @param secondTeam
     * @return
     */
    @ResponseBody
    @RequestMapping("getFirst")
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
        System.out.println("jsonObject:" + jsonObject);
        return JSON.toJSONString(jsonObject.toString());
    }

    /**
     * 写死方法，返回1队和2队
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("getFirstNoParm")
    public String getFirstNoParm() {
        List<Member> memberList = memberService.gainAllMember();
        List<FirstStarting> firstList = new ArrayList<>();
        List<FirstStarting> secondList = new ArrayList<>();
        JSONObject jsonObject = new JSONObject();
        for (Member member : memberList) {
            FirstStarting first = new FirstStarting();
            FirstStarting second = new FirstStarting();
            if (1 == member.getTeamId()) {//判断是否该球队ID
                if (1 == member.getMemberFirstStart()) {//判断是否首发
                    first.setMemberId(member.getMemberId());
                    firstList.add(first);
                }
            }
            if (2 == member.getTeamId()) {
                if (1 == member.getMemberFirstStart()) {//判断是否首发
                    second.setMemberId(member.getMemberId());
                    secondList.add(second);
                }
            }

        }
        jsonObject.put("first", firstList);
        jsonObject.put("second", secondList);
        System.out.println("jsonObject:" + jsonObject);
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
    @RequestMapping("getLeftAll")
    public String getLeftAll(int teamId) {
        //获取所有球员（不分队的）
        List<Member> memberList = memberService.gainAllMember();
        List<FirstStarting> leftmemberList = new ArrayList<>();
        JSONObject jsonObj = new JSONObject();
        for (Member member : memberList) {
            FirstStarting noFirstStarting = new FirstStarting();
            if (teamId == member.getTeamId()) {//判断是否属于请求的球队
                if (0 == member.getMemberFirstStart()) {//判断是否首发
                    noFirstStarting.setMemberId(member.getMemberId());
                    leftmemberList.add(noFirstStarting);
                }
            }

        }
        jsonObj.put("noFirstStart", leftmemberList);
        System.out.println("jsonObject:" + jsonObj);
        return JSON.toJSONString(jsonObj.toString());
    }

    /*加分方式：
     * 前台点击球员加分操作后返回加的分值(1,2,3)、球员编号、球员所在队伍编号、得分时刻（节+时刻）
     * 数据库操作相应球员加分，这是记录个人得分
     * 总分可由后台计算返回，也可由前台进行计算显示
     * 返回操作状态
     */
    /*犯规处理方式：
     * 前台点击球员编号，点击犯规操作返回犯规值0、球员编号、球员所在队伍编号、犯规时刻（节+时刻）
     * 后台记录
     * 返回操作状态
     */

    /**
     * 点击球员编号的操作(加分，犯规)
     *
     * @param matchSection
     * @param matchTime
     * @param eventType
     * @param memberId
     * @param teamId
     * @return
     */
    @ResponseBody
    @RequestMapping("clickOperate")
    public String clickOperate(int matchSection, String matchTime,
                               int eventType, int memberId, int teamId) {
        int status;
        String operateMsg;
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            //设置状态
            operateMsg = "success";
            status = 200;
            //添加一条记录并返回状态
            boolean operateStatus = matchService.addMatch(matchSection, matchTime, eventType, memberId, teamId);
            if (operateStatus) {
                //状态封装成map集合
                map.put("operateMsg", operateMsg);
                map.put("status", status);
            }
        } catch (Exception e) {
            e.printStackTrace();
            operateMsg = "error";
            status = 404;
            map.put("operateMsg", operateMsg);
            map.put("status", status);
        }
        //map集合封装层JSON对象
        String mapString = JSON.toJSONString(map);
        return JSON.toJSONString(mapString);
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
     *
     * @param teamId
     * @param firstMemberId
     * @param secMemberId
     * @return
     */
    @ResponseBody
    @RequestMapping("exchangeMember")
    public String exchangeMember(int teamId, int firstMemberId, int secMemberId) {

        JSONObject jsonObject = new JSONObject();
        /*更改根据被换下场的球员编号、球员所在队伍编号查询出的队员的上场状态*/
        boolean firstStatus = memberService.toNotIsFirst(firstMemberId, teamId, 0);
        /*更改将上场的球员球员编号、球员所在队伍编号查询出的队员的上场状态*/
        boolean secStatus = memberService.toIsFirst(secMemberId, teamId, 1);
        if (firstStatus && secStatus) {
            //设置状态并封装成JSON对象
            jsonObject.put("status", "exchangeMemberSuccess");
            System.out.println(jsonObject);
        } else {
            jsonObject.put("status", "exchangeMemberFail");
            System.out.println(jsonObject);
        }
        //返回状态
        return JSON.toJSONString(jsonObject.toString());
    }

}
