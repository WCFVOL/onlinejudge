package com.wcfvol.onlinejudge.dao;

import com.wcfvol.onlinejudge.pojo.po.gen.Announcements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AnnouncementsDAOTest {

    @Autowired
    private AnnouncementsDAO announcementsDAO;

    @Test
    public void queryAll() {
        System.out.println(announcementsDAO.queryAll());
    }

    @Test
    public void addAnnouncement() {

    }
}