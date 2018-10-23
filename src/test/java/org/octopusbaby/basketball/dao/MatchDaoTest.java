package org.octopusbaby.basketball.dao;

import org.junit.Test;
import org.octopusbaby.basketball.BaseTest;
import org.octopusbaby.basketball.entity.Match;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MatchDaoTest extends BaseTest {

    @Autowired
    private MatchDao matchDao;

    @Test
    public void testGetAllInfo() {
        List<Match> allInfo = matchDao.getAllInfo();
        for (Match match : allInfo) {
            System.out.println("\n\n" + match + "\n");
        }
    }

    @Test
    public void testGetByMIdAndTId() {
        Match match = matchDao.getByMIdAndTId(23, 2);
        System.out.println("\n\n" + match + "\n");
    }

    @Test
    public void testInsertMatch() {
        boolean b = matchDao.insertMatch("12:40", 2, 23, 1);
        if (b) {
            System.out.println("\n\n" + "成功添加一条对站记录" + "\n");
        }
    }

    @Test
    public void testDeleteMatch() {
        matchDao.delMatch("12:40", 2, 23);
    }
}
