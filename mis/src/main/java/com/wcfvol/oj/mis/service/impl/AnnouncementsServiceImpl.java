package com.wcfvol.oj.mis.service.impl;

import com.wcfvol.oj.mis.mapper.dao.AnnouncementsDAO;
import com.wcfvol.oj.mis.pojo.data.Announcements;
import com.wcfvol.oj.mis.pojo.params.AnnouncementsQueryParam;
import com.wcfvol.oj.mis.service.AnnouncementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementsServiceImpl implements AnnouncementsService {
    @Autowired
    AnnouncementsDAO announcementsDAO;

    @Override
    public List<Announcements> getAllAnnouncements(AnnouncementsQueryParam param) {
        return announcementsDAO.queryAll(param);
    }

    @Override
    public void addAnnouncements(Announcements announcements) {
        announcementsDAO.addAnnouncement(announcements);
    }
}
