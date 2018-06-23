package com.wcfvol.onlinejudge.controller;

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
public class HomeController {

    @Autowired
    private AnnouncementsService announcementsService;


    @RequestMapping(value = "/announcement",method = RequestMethod.GET)
    @ResponseBody
    public List<Announcements> getAnnouncements() {
        return announcementsService.getAllAnnouncements();
    }
}
