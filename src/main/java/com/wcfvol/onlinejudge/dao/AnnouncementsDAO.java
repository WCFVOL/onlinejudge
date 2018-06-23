package com.wcfvol.onlinejudge.dao;

import com.wcfvol.onlinejudge.po.Announcements;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Wang Chunfei
 */
@Mapper
public interface AnnouncementsDAO {
    // private String TABLE_NAME="announcements";
    @Select("SELECT * FROM announcements")
    List<Announcements> queryAll();

}
