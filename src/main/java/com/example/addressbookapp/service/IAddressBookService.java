package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBookData;
import com.example.addressbookapp.exception.AddressBookException;

import java.util.List;

public interface IAddressBookService {
    List<AddressBookData> getAllContacts();
    AddressBookData getContactById(int id);
    AddressBookData createContact(AddressBookDTO dto);
    AddressBookData updateContact(int id, AddressBookDTO dto);
    void deleteContact(int id);
}
