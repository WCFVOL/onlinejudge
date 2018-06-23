package com.wcfvol.onlinejudge.service;

import com.wcfvol.onlinejudge.po.Announcements;

import java.util.List;

public interface AnnouncementsService {
    public List<Announcements> getAllAnnouncements() ;
    public void addAnnouncements(Announcements announcements);
}
