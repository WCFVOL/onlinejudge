package com.wcfvol.onlinejudge.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.wcfvol.onlinejudge.po.Announcements;
import com.wcfvol.onlinejudge.service.AnnouncementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Wang Chunfei
 */
@Controller
@RequestMapping(value = "/api")
public class HomeController {

    @Autowired
    private AnnouncementsService announcementsService;


    @RequestMapping(value = "/announcements",method = RequestMethod.GET)
    @ResponseBody
    public List<Announcements> getAnnouncements() {
        return announcementsService.getAllAnnouncements();
    }
    @RequestMapping(value = "/addAnnouncement",method = RequestMethod.POST)
    @ResponseBody
    public String addAnnouncement(@RequestBody Announcements announcements) {
        announcementsService.addAnnouncements(announcements);
        return "{\"ok\":1}";
    }
}
