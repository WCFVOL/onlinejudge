package com.wcfvol.onlinejudge.service;

import com.wcfvol.onlinejudge.pojo.data.Announcements;
import com.wcfvol.onlinejudge.pojo.params.AnnouncementsQueryParam;

import java.util.List;

public interface AnnouncementsService {
    public List<Announcements> getAllAnnouncements(AnnouncementsQueryParam param) ;
    public void addAnnouncements(Announcements announcements);
}
