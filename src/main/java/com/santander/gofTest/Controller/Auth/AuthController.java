package com.santander.gofTest.Controller.Auth;

import com.santander.gofTest.DTO.LoginDTO;
import com.santander.gofTest.Models.Users.User;
import com.santander.gofTest.Repository.UserRepo;
import com.santander.gofTest.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenService tokenService;

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = authenticationManager.authenticate(usernamePassword);

        UserDetails u = userRepo.findByEmail(data.email());
        String token = tokenService.generate((User) u);

        if (passwordEncoder.matches(data.password(), u.getPassword())) {
            return ResponseEntity.status(200).body(token);
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("wrong password");
    }
}


