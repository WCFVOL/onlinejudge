package com.wcfvol.onlinejudge.dao;

import com.wcfvol.onlinejudge.po.Announcements;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Wang Chunfei
 */
@Mapper
public interface AnnouncementsDAO {
    String TABLE_NAME = "user";
    String INSET_FIELDS = " title, date, author, author_id, contest ";
    String SELECT_FIELDS = " id, name, password, salt, head_url";
    @Select("SELECT * FROM announcements")
    List<Announcements> queryAll();

    @Insert({"INSERT INTO ",TABLE_NAME," ( ",INSET_FIELDS, ") VALUES (#{title}, #{date} , #{author}, #{authorId}, #{contest})" })
    void addAnnouncement(Announcements announcements);
}
