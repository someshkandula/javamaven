package com.somesh.sbmaven.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class PingController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/codeDecode")
    public void codeDecodeGetMethod() {
        System.out.println ("Server port is :::: "+serverPort);
    }
}
