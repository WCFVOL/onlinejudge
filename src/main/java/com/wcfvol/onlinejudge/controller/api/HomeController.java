package com.wcfvol.onlinejudge.controller.api;

import com.wcfvol.onlinejudge.pojo.data.Announcements;
import com.wcfvol.onlinejudge.pojo.RestResult;
import com.wcfvol.onlinejudge.pojo.params.AnnouncementsQueryParam;
import com.wcfvol.onlinejudge.service.AnnouncementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Wang Chunfei
 */
@Controller
@RequestMapping(value = "/api")
public class HomeController {

    @Autowired
    private AnnouncementsService announcementsService;


    @RequestMapping(value = "/announcements",method = RequestMethod.POST)
    @ResponseBody
    public RestResult getAnnouncements(@RequestBody AnnouncementsQueryParam param) {
        return RestResult.ok().setData( announcementsService.getAllAnnouncements(param));
    }

}
