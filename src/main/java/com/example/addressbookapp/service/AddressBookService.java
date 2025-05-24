package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBookData;
import com.example.addressbookapp.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.addressbookapp.exception.AddressBookException;

import java.util.List;

@Slf4j
@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepository repository;

    @Override
    public List<AddressBookData> getAllContacts() {
        log.info("Fetching all contacts");
        return repository.findAll();
    }

    @Override
    public AddressBookData getContactById(int id) {
        log.info("Fetching contact by id: {}", id);
        return repository.findById(id).orElseThrow(() -> new AddressBookException("Contact with ID " + id + " not found"));
    }

    @Override
    public AddressBookData createContact(AddressBookDTO dto) {
        log.info("Creating new contact with name: {}", dto.getName());
        AddressBookData data = new AddressBookData(dto.getName(), dto.getAddress(), dto.getPhone());
        AddressBookData savedData = repository.save(data);
        log.info("Created contact with id: {}", savedData.getId());
        return savedData;
    }

    @Override
    public AddressBookData updateContact(int id, AddressBookDTO dto) {
        log.info("Updating contact with id: {}", id);
        AddressBookData contact = repository.findById(id).orElse(null);
        if (contact != null) {
            contact.setName(dto.getName());
            contact.setAddress(dto.getAddress());
            contact.setPhone(dto.getPhone());
            AddressBookData updatedContact = repository.save(contact);
            log.info("Updated contact with id: {}", id);
            return updatedContact;
        }
        log.warn("Contact with id {} not found for update", id);
        return null;
    }

    @Override
    public void deleteContact(int id) {
        log.info("Deleting contact with id: {}", id);
        AddressBookData contact = repository.findById(id).orElseThrow(() -> new AddressBookException("Contact with ID " + id + " not found"));            
        repository.delete(contact);
    }
}
