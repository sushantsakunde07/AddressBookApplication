package com.bridgelabz.addressbookapplication.service;

import com.bridgelabz.addressbookapplication.dto.AddressBookDto;
import com.bridgelabz.addressbookapplication.entity.Person;

import java.util.List;
public interface AddressBookService {
    List<Person> getAddressBookDetails();
    Person getAddressDetailsById(int personId);
    Person createAdddressBookDetails(AddressBookDto addressBookDto);
    Person updateAddressBookDetails(int personId, AddressBookDto addressBookDto);
    void deleteAddressDetails(int personId);

}