package com.wcfvol.oj.mis.mapper.dao;

import com.wcfvol.oj.mis.pojo.data.Announcements;
import com.wcfvol.oj.mis.pojo.params.AnnouncementsQueryParam;
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
