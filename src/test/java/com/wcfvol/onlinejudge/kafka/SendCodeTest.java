package com.wcfvol.onlinejudge.kafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SendCodeTest {
    @Autowired
    SendCode sendCode;

    @Test
    public void send() {
        sendCode.send("test","666");
    }
}