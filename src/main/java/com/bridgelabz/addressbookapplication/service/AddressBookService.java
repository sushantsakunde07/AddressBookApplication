package com.bridgelabz.addressbookapplication.service;

import com.bridgelabz.addressbookapplication.dto.AddressBookDto;
import com.bridgelabz.addressbookapplication.entity.Person;

import java.util.List;
public interface AddressBookService {
    List<Person> getAddressBookDetails();
    Person getAddressDetailsById(Long personId);
    Person createAddressBookDetails(AddressBookDto addressBookDto);
    Person updateAddressBookDetails(Long personId, AddressBookDto addressBookDto);
    void deleteAddressDetails(Long personId);

}