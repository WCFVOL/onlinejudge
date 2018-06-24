package com.wcfvol.onlinejudge.dao;

import com.wcfvol.onlinejudge.po.Announcements;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Wang Chunfei
 */
@Mapper
public interface AnnouncementsDAO {
    String TABLE_NAME = "announcements";
    String INSET_FIELDS = " title, date, author, author_id, content ";
    String SELECT_FIELDS = " id, title, date, author, author_id, content ";
    @Select("SELECT * FROM announcements")
    List<Announcements> queryAll();

    @Insert({"INSERT INTO ",TABLE_NAME," ( ",INSET_FIELDS, ") VALUES (#{title}, #{date} , #{author}, #{authorId}, #{content})" })
    void addAnnouncement(Announcements announcements);
}
