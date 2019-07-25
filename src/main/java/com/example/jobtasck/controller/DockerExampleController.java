package com.example.jobtasck.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerExampleController {

    @GetMapping("/hello")
    public ResponseEntity sayHello() {
        return ResponseEntity.ok("Hello");
    }
}
