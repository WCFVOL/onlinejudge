package com.wcfvol.onlinejudge.pojo.data;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Wang Chunfei
 */
@Data
public class Announcements {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private int id;
    private String title;
    private String author;
    private String content;
    private int authorId;
}
