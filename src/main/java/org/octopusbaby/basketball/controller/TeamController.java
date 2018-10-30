package org.octopusbaby.basketball.controller;

import org.octopusbaby.basketball.service.MatchService;
import org.octopusbaby.basketball.service.MemberService;
import org.octopusbaby.basketball.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    public ModelAndView addTeamAndMember(int teamId, String teamName,
                                         int memberId, String memberName,
                                         int mbFirstStart) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("");
        return mv;
        /*一对多的表  查询，待学习*/
    }

    public ModelAndView getHistoryMatch() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("history");
        return mv;

        /* 需要建立一个历史信息数据库表
         *  并且在比赛结束后前端返回数据
         *  然后接收处理存储*/
    }
}
