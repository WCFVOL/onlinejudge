package com.wcfvol.onlinejudge.kafka;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;



@Service
public class SendCode {

    public void send(String data) throws URISyntaxException {
        URI uri = new URI("http://127.0.0.1:8080/task");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        LinkedMultiValueMap<String,String> map = new LinkedMultiValueMap<String,String>();
        map.add("task",data);
        HttpEntity<MultiValueMap<String,String>> httpEntity = new HttpEntity<>(map,httpHeaders);
        ResponseEntity<String> resp = restTemplate.postForEntity(uri,httpEntity,String.class);
        System.out.println(resp.getStatusCode());
        System.out.println(resp.getStatusCodeValue());
    }
}
