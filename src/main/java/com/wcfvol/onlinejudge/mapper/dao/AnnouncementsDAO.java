package com.wcfvol.onlinejudge.mapper.dao;

import com.wcfvol.onlinejudge.pojo.data.Announcements;
import com.wcfvol.onlinejudge.pojo.params.AnnouncementsQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Wang Chunfei
 */
@Mapper
public interface AnnouncementsDAO {
    List<Announcements> queryAll(AnnouncementsQueryParam param);
    void addAnnouncement(Announcements announcements);
}
