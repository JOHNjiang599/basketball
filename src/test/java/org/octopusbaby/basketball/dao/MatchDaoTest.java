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
}
