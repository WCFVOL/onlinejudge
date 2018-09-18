package com.wcfvol.onlinejudge.dao;

import com.wcfvol.onlinejudge.pojo.data.Announcements;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Wang Chunfei
 */
@Mapper
public interface AnnouncementsDAO {
    List<Announcements> queryAll();
    void addAnnouncement(Announcements announcements);
}
