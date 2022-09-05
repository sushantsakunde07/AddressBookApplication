package com.bridgelabz.addressbookapplication.entity;

import com.bridgelabz.addressbookapplication.dto.AddressBookDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public @Data class Person {
    private int personId;
    private String firstName;
    private String lastName;
    private String gender;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String emailId;

    public Person(int personId, AddressBookDto addressBookDto) {
        this.personId = personId;
        this.firstName = addressBookDto.firstName;
        this.lastName = addressBookDto.lastName;
        this.gender = addressBookDto.gender;
        this.address = addressBookDto.address;
        this.city = addressBookDto.city;
        this.state = addressBookDto.state;
        this.zipCode = addressBookDto.zipCode;
        this.phoneNumber = addressBookDto.phoneNumber;
        this.emailId = addressBookDto.emailId;
    }
}