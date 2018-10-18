package org.octopusbaby.basketball.dao;

import org.junit.Test;
import org.octopusbaby.basketball.BaseTest;
import org.octopusbaby.basketball.entity.Match;
import org.springframework.beans.factory.annotation.Autowired;

public class MatchDaoTest extends BaseTest {

    @Autowired
    private MatchDao matchDao;

    @Test
    public void testGetAllInfo() {
        Match allInfo = matchDao.getAllInfo();
        System.out.println("\n\n" + allInfo + "\n");
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
        matchDao.deleteMatch("12:40", 2, 23);
    }
}
