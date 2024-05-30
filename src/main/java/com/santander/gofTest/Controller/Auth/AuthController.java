package com.santander.gofTest.Controller.Auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @PostMapping(value = "/login")
    public ResponseEntity<String> login() {
        return ResponseEntity.status(200).body("ok, reached login");
    }
}


