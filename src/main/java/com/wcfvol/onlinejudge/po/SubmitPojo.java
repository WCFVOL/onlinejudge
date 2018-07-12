package com.wcfvol.onlinejudge.po;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.Date;
@Data
public class SubmitPojo {
    private String code;
    private String username;
    private int problemId;
    private int language;
    private int id;
    private int testCase;
    private int timeLimit;
    private int memLimit;
    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",id);
        jsonObject.put("code",code);
        jsonObject.put("username",username);
        jsonObject.put("problemId",problemId);
        jsonObject.put("language",language);
        jsonObject.put("testCase",testCase);
        jsonObject.put("timeLimit",timeLimit);
        jsonObject.put("memLimit",memLimit);
        return jsonObject.toJSONString();
    }
}
