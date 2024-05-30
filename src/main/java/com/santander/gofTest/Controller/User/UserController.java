package com.santander.gofTest.Controller.User;

import com.santander.gofTest.Models.Users.User;
import com.santander.gofTest.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @GetMapping(value = "/users/address/{id}")
    public List<Object[]> get(@PathVariable int id) {
        return userRepo.findAddressFromUser(id);
    }

    @PostMapping(value = "/user/add")
    public void add(@RequestBody User user) {

        userRepo.save(user);
    }

    @PutMapping(value = "/user/update/{id}")
    public void upd(@PathVariable long id, @RequestBody User user) {
        User u = userRepo.findById(id).get();
        u.update(user);
        userRepo.save(u);
    }

    @DeleteMapping(value = "/user/delete/{id}")
    public void del(@PathVariable long id) {
        userRepo.deleteById(id);
    }
}



