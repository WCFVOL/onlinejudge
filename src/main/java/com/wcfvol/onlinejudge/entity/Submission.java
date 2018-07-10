package com.wcfvol.onlinejudge.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.Date;


/**
 * @author Wang Chunfei
 */
@Data
public class Submission {
    private int id;
    private String code;
    private String username;
    private Date date;
    private int problemId;
    private int result;
    private double time;
    private int memory;
    private int length;
    private int language;
    public String toSubmitString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",id);
        jsonObject.put("code",code);
        jsonObject.put("userId",username);
        jsonObject.put("date",date);
        jsonObject.put("problemId",problemId);
        jsonObject.put("language",language);
        return jsonObject.toJSONString();
    }
}
