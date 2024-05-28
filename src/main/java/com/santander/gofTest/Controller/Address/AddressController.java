package com.santander.gofTest.Controller.Address;

import com.santander.gofTest.Models.Address.Address;
import com.santander.gofTest.Repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/address")
public class AddressController {

    @Autowired
    private AddressRepo addressRepo;

    @GetMapping(value = "/")
    public List<Address> addresses() {
        return addressRepo.findAll();
    }

    @PostMapping(value = "/add")
    public void add(@RequestBody Address address) {
        addressRepo.save(address);
    }

    @PutMapping(value = "/update/{id}")
    public void upd(@PathVariable long id, @RequestBody Address address) {
        Address a = addressRepo.findById(id).get();
        a.update(address);
        addressRepo.save(a);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void del(@PathVariable long id) {
        addressRepo.deleteById(id);
    }
}




