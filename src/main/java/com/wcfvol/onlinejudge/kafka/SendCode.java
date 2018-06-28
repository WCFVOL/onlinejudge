package com.wcfvol.onlinejudge.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SendCode {
    @Autowired
    private KafkaTemplate template;

    public void send(String topic, String data){
        template.send(topic,data);
    }
}
