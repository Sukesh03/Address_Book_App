package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBookData;
import com.example.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepository repository;

    @Override
    public List<AddressBookData> getAllContacts() {
        return repository.findAll();
    }

    @Override
    public AddressBookData getContactById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public AddressBookData createContact(AddressBookDTO dto) {
        AddressBookData data = new AddressBookData(dto.getName(), dto.getAddress(), dto.getPhone());
        return repository.save(data);
    }

    @Override
    public AddressBookData updateContact(int id, AddressBookDTO dto) {
        AddressBookData contact = repository.findById(id).orElse(null);
        if (contact != null) {
            contact.setName(dto.getName());
            contact.setAddress(dto.getAddress());
            contact.setPhone(dto.getPhone());
            return repository.save(contact);
        }
        return null;
    }

    @Override
    public void deleteContact(int id) {
        repository.deleteById(id);
    }
}
