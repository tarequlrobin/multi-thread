package com.crud_springboot3_jpa.controller;

import com.crud_springboot3_jpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/readCSVFile")
    public ResponseEntity<Object> readCSVFile() throws IOException {
        userService.readLeadsFromCSV();
        return ResponseEntity.ok("OK");
    }
}