package com.wcfvol.onlinejudge.service;

import com.wcfvol.onlinejudge.pojo.data.Announcements;

import java.util.List;

public interface AnnouncementsService {
    public List<Announcements> getAllAnnouncements() ;
    public void addAnnouncements(Announcements announcements);
}
