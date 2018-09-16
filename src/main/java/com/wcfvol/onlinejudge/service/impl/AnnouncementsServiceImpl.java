package com.wcfvol.onlinejudge.service.impl;

import com.wcfvol.onlinejudge.dao.AnnouncementsDAO;
import com.wcfvol.onlinejudge.pojo.po.gen.Announcements;
import com.wcfvol.onlinejudge.service.AnnouncementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementsServiceImpl implements AnnouncementsService {
    @Autowired
    AnnouncementsDAO announcementsDAO;

    @Override
    public List<Announcements> getAllAnnouncements() {
        return announcementsDAO.queryAll();
    }

    @Override
    public void addAnnouncements(Announcements announcements) {
        announcementsDAO.addAnnouncement(announcements);
    }
}
