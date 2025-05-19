package com.example.addressbook.controller;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.model.AddressBookData;
import com.example.addressbook.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService service;

    @GetMapping
    public ResponseEntity<List<AddressBookData>> getAll() {
        return ResponseEntity.ok(service.getAllContacts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBookData> getById(@PathVariable int id) {
        AddressBookData data = service.getContactById(id);
        return data != null ? ResponseEntity.ok(data) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AddressBookData> create(@RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(service.createContact(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressBookData> update(@PathVariable int id, @RequestBody AddressBookDTO dto) {
        AddressBookData updated = service.updateContact(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.deleteContact(id);
        return ResponseEntity.noContent().build();
    }
}
