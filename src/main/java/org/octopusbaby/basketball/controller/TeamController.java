package org.octopusbaby.basketball.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.octopusbaby.basketball.dto.HistoryResult;
import org.octopusbaby.basketball.entity.Match;
import org.octopusbaby.basketball.entity.Team;
import org.octopusbaby.basketball.service.MatchService;
import org.octopusbaby.basketball.service.MemberService;
import org.octopusbaby.basketball.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 处理球队登录之后的请求
 */
@Controller
@RequestMapping("team")
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

    /**
     * 添加球队队伍
     *
     * @param teamId
     * @param teamName
     * @param memberId
     * @param memberName
     * @param isFirst
     * @return
     */
    @RequestMapping("addOneTeam")
    public ModelAndView addTeamAndMember(int teamId, String teamName,
                                         int memberId, String memberName,
                                         int isFirst) {
        HttpSession session = null;
        ModelAndView mv = new ModelAndView();
        //添加队伍并返回状态
        boolean addTeamStatus = teamService.addTeam(teamId, teamName);
        boolean addMemberStatus = memberService.addMember(memberId, memberName, isFirst, teamId);
        if (addTeamStatus && addMemberStatus) {
            //将状态返回到session中
            session.setAttribute("status", "add success");
            mv.setViewName("");
        } else {
            session.setAttribute("status", "input error");
            mv.setViewName("");
        }
        return mv;
    }

    /**
     * 通过两个队的ID来获取两队之间的比赛记录
     *
     * @param firstTeamId
     * @param secTeamId
     * @return
     */
    @ResponseBody
    @RequestMapping("getHistory")
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
        System.out.println("\n jsonObject:" + jsonObject);
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
    @RequestMapping("getHistory")
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
        System.out.println("\n jsonObject:" + jsonObject);
        //返回球队ID，球队名字，球队总得分JSON字符串
        return JSON.toJSONString(jsonObject.toString());
    }
}
