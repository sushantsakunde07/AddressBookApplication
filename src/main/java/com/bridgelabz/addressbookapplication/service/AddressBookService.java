package com.bridgelabz.addressbookapplication.service;

import com.bridgelabz.addressbookapplication.dto.AddressBookDto;
import com.bridgelabz.addressbookapplication.dto.ResponseDto;
import com.bridgelabz.addressbookapplication.entity.Person;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface AddressBookService {
    List<Person> getAddressBookDetails(String token);

    // List<Person> getAddressBookDetails();

    Person getAddressBookDetailsById(Long personId);

    List<Person> getPersonByFirstName(String firstName);

    List<Person> getPersonByLastName(String lastName);

    List<Person> getPersonByGender(String gender);

    List<Person> getPersonByAddress(String address);

    List<Person> getPersonByCity(String city);

    List<Person> getPersonByState(String state);

    List<Person> getPersonByZipCode(String zipCode);

    List<Person> getPersonByPhoneNumber(String phoneNumber);

    Optional<Person> getPersonByEmailId(String emailId);

    Person createAddressBookDetails(@Valid AddressBookDto addressBookDTO);

    // @Override
   /* public Person getAddressDetailsById(int personId) {
        for (Person person : personList) {
            if (person.getPersonId() == personId) {
                return person;
            }
        }
        return null;
    }*/
    // Person createAddressBookDetails(AddressBookDto addressBookDto);

    Person updateAddressBookDetails(long personId, AddressBookDto addressBookDto);

    void deleteAddressBookDetails(long personId);

    ResponseDto login(String emailId, String password);
}