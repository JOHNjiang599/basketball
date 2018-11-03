package org.octopusbaby.basketball.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.octopusbaby.basketball.BaseTest;
import org.octopusbaby.basketball.dto.HistoryResult;
import org.octopusbaby.basketball.entity.Match;
import org.octopusbaby.basketball.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MatchServiceTest extends BaseTest {

    @Autowired
    private MatchService matchService;

    @Autowired
    private TeamService teamService;

    /**
     * 业务层测试
     * 通过两队ID获取两队的对战历史记录
     */
    @Test
    public void getHistoryById() {
        int firstTeamId = 1;
        int secTeamId = 2;
        //通过球队ID获取比赛记录
        List<Match> firstMatches = matchService.gainByTeamId(firstTeamId);
        List<Match> secMatches = matchService.gainByTeamId(secTeamId);
        //通过球队ID获取球队名字
        Team firstTeam = teamService.gainByTeamId(firstTeamId);
        Team secTeam = teamService.gainByTeamId(secTeamId);
        System.out.println("\n" + firstTeam.getTeamId() + "等于" + firstTeamId);
        System.out.println("\n" + secTeam.getTeamId() + "等于" + secTeamId);
        //初始化分数
        int firstTeamScore = 0;
        int secTeamScore = 0;
        //统计分数
        for (Match firstMatch : firstMatches) {
            System.out.println("\n一队：" + firstMatch);
            firstTeamScore += firstMatch.getEventType();
        }
        for (Match secMatch : secMatches) {
            System.out.println("\n二队：" + secMatch);
            secTeamScore += secMatch.getEventType();
        }
        System.out.println("\n firstTeamScore = " + firstTeamScore);
        System.out.println("\n secTeamScore = " + secTeamScore);
        //将球队ID，球队名字，球队总得分封装成对象
        HistoryResult firstHistoryResult = new HistoryResult();
        firstHistoryResult.setTeamId(firstTeam.getTeamId());
        firstHistoryResult.setTeamName(firstTeam.getTeamName());
        firstHistoryResult.setScore(firstTeamScore);

        HistoryResult secHistoryResult = new HistoryResult();
        secHistoryResult.setTeamId(secTeam.getTeamId());
        secHistoryResult.setTeamName(secTeam.getTeamName());
        secHistoryResult.setScore(secTeamScore);
        //将球队ID，球队名字，球队总得分封装成JSON对象
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstTeamScore", firstHistoryResult);
        jsonObject.put("secTeamScore", secHistoryResult);
        System.out.println("\n jsonObject:" + jsonObject);
        String rs = JSON.toJSONString(jsonObject.toString());
        System.out.println("\n rs:" + rs);
    }

    /**
     * 业务层测试
     * 通过两队名称获取两队的对战历史记录
     */
    @Test
    public void getHistoryByName() {
        String firstTeamName = "asd";
        String secTeamName = "dfg";
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
        String jsonString = JSON.toJSONString(jsonObject.toString());
        System.out.println(jsonString);
    }

    /**
     * 业务层测试
     * 获取所有比赛信息
     */
    @Test
    public void testGainAllInfo() {
        List<Match> matches = matchService.gainAllInfo();
        for (Match match : matches) {
            System.out.println("\n" + match);
        }
    }

    /**
     * 业务层测试
     * 通过球员ID和球队ID获取所有比赛信息
     */
    @Test
    public void testGainByMIdAndTId() {
        int memberId = 23;
        int teamId = 1;
        List<Match> matches = matchService.gainByMIdAndTId(memberId, teamId);
        for (Match match : matches) {
            System.out.println("\n" + match);
        }
    }

    /**
     * 业务层测试
     * 添加一条比赛记录
     */
    @Test
    public void testAddMatch() {
        int matchSection = 1;
        String matchTime = "12:40";
        int eventType = 2;
        int memberId = 23;
        int teamId = 1;
        boolean b = matchService.addMatch(matchSection, matchTime, eventType, memberId, teamId);
        if (b) {
            System.out.println("\n\n" + "成功添加一条对站记录" + "\n");
        }
    }

    /**
     * 业务层测试
     * 删除一条比赛记录
     */
    @Test
    public void testDeleteMatch() {
        String matchTime = "12:40";
        int eventType = 2;
        int memberId = 23;
        boolean b = matchService.deleteMatch(matchTime, eventType, memberId);
    }

    /**
     * 业务层测试
     * 修改一条比赛记录
     */
    @Test
    public void testModifyOneMatch() {
        String matchTime = "12:40";
        int eventType = 0;
        int memberId = 0;
        boolean b = matchService.modifyOneMatch(matchTime, eventType, memberId);
    }
}
