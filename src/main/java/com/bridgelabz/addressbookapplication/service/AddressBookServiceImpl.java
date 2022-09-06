package com.bridgelabz.addressbookapplication.service;

import com.bridgelabz.addressbookapplication.dto.AddressBookDto;
import com.bridgelabz.addressbookapplication.entity.Person;
import com.bridgelabz.addressbookapplication.exception.AddressBookException;
import com.bridgelabz.addressbookapplication.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AddressBookServiceImpl implements AddressBookService {
    @Autowired
    private AddressBookRepository addressBookRepository;
    private List<Person> personList = new ArrayList<>();

    @Override
    public List<Person> getAddressBookDetails() {
        return addressBookRepository.findAll();
    }

    @Override
    public Person getAddressDetailsById(Long personId) {
        return addressBookRepository.findById(personId).orElseThrow(() -> new AddressBookException("User Not Found"));
    }

    // @Override
   /* public Person getAddressDetailsById(int personId) {
        for (Person person : personList) {
            if (person.getPersonId() == personId) {
                return person;
            }
        }
        return null;
    }*/
    @Override
    public Person createAddressBookDetails(AddressBookDto addressBookDto) {
        Person person = null;
        person = new Person(personList.size() + 1, addressBookDto);
        log.debug("User Data: " + personList.toString());
        personList.add(person);
        return person;
    }

    @Override
    public Person updateAddressBookDetails(Long personId, AddressBookDto addressBookDto) {
        Person personDetails = this.getAddressDetailsById(personId);
        personDetails.setFirstName(addressBookDto.firstName);
        personDetails.setLastName(addressBookDto.lastName);
        personDetails.setGender(addressBookDto.gender);
        personDetails.setAddress(addressBookDto.address);
        personDetails.setCity(addressBookDto.city);
        personDetails.setState(addressBookDto.state);
        personDetails.setZipCode(addressBookDto.zipCode);
        personDetails.setEmailId(addressBookDto.emailId);
        personDetails.setPhoneNumber(addressBookDto.phoneNumber);
        return personDetails;
    }

    @Override
    public void deleteAddressDetails(Long personId) {
        Person personDetails = this.getAddressDetailsById(personId);
        personList.remove(personDetails);
    }
}