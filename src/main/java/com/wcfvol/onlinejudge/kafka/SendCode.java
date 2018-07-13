package com.wcfvol.onlinejudge.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class SendCode {
    @Autowired
    private KafkaTemplate<String, String> template;

    public void send(String topic, String data) throws ExecutionException, InterruptedException {
        template.send(new ProducerRecord<String,String>(topic,data)).get();
    }
}
