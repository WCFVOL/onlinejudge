package com.wcfvol.onlinejudge.controller;

import com.wcfvol.onlinejudge.po.Announcements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Wang Chunfei
 */
@Controller
public class HomeController {
    @RequestMapping(value = "announcement",method = RequestMethod.GET)
    public Announcements getAnnouncements() {
        //todo
        return new Announcements();
    }
}
