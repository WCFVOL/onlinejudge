package com.wcfvol.oj.mis.service;

import com.wcfvol.oj.mis.pojo.data.Announcements;
import com.wcfvol.oj.mis.pojo.params.AnnouncementsQueryParam;

import java.util.List;

public interface AnnouncementsService {
    public List<Announcements> getAllAnnouncements(AnnouncementsQueryParam param) ;
    public void addAnnouncements(Announcements announcements);
}
