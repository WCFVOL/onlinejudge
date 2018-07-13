package com.wcfvol.onlinejudge.kafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SendCodeTest {
    @Autowired
    SendCode sendCode;

    @Test
    public void send() throws ExecutionException, InterruptedException {
        sendCode.send("test","{\"data\":\"{\\\"input\\\":\\\"11\\\\n\\\",\\\"caseId\\\":0,\\\"problemId\\\":1}\",\"taskId\":2}\n");
    }
}