package com.wcfvol.onlinejudge.pojo.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Wang Chunfei
 */
@Data
public class Announcements {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date date;
    private int id;
    private String title;
    private String author;
    private String content;
}
