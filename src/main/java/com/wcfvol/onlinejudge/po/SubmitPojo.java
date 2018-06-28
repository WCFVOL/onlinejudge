package com.wcfvol.onlinejudge.po;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.Date;
@Data
public class SubmitPojo {
    private String code;
    private int userId;
    private Date date;
    private int problemId;

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put("userId",userId);
        jsonObject.put("date",date);
        jsonObject.put("problemId",problemId);
        return jsonObject.toJSONString();
    }
}
