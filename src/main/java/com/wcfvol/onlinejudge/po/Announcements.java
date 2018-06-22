package com.wcfvol.onlinejudge.po;

import lombok.Data;

import java.util.Date;

/**
 * @author Wang Chunfei
 */
@Data
public class Announcements {
    private Date date;
    private int id;
    private String title;
    private String author;
    private String content;
}
