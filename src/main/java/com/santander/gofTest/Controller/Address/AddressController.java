package com.santander.gofTest.Controller.Address;

import com.santander.gofTest.Models.Address.Address;
import com.santander.gofTest.Repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/address")
public class AddressController {

    @Autowired
    private AddressRepo addressRepo;

    @GetMapping(value = "/")
    public ResponseEntity<List<Address>> addresses() {
        return ResponseEntity.status(HttpStatus.OK).body(addressRepo.findAll());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> add(@RequestBody Address address) {
        addressRepo.save(address);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> upd(@PathVariable long id, @RequestBody Address address) throws RuntimeException {
        if (addressRepo.findById(id).isEmpty()) throw new RuntimeException("address not found");
        Address a = addressRepo.findById(id).get();
        a.update(address);
        addressRepo.save(a);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> del(@PathVariable long id) throws RuntimeException {
        if (addressRepo.findById(id).isEmpty()) throw new RuntimeException("address not found");
        addressRepo.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}




