package com.wcfvol.onlinejudge.po;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @ClassName TaskPojo
 * @Author Wang Chunfei
 * @Date 2018/7/6 下午4:03
 **/
@Data
public class TaskPojo {
    int taskId;
    String data;
    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("taskId",taskId);
        jsonObject.put("data",data);
        return jsonObject.toJSONString();
    }
}
