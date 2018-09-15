package com.wcfvol.onlinejudge.client;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;



@Service
public class SendCode {

    @Value("${judger.path}")
    private static String JUDGER_PATH;

    public void send(String data) throws URISyntaxException {
        URI uri = new URI(JUDGER_PATH+"/task");
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
