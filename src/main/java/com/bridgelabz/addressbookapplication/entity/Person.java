package com.bridgelabz.addressbookapplication.entity;

import com.bridgelabz.addressbookapplication.dto.AddressBookDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_address_book")
public @Data class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personId")
    private int personId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "phone_number")
    private String phoneNumber;

    @ElementCollection
    @CollectionTable(name = "person_emailId", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "emailId")
    private List<String> emailId = new ArrayList<>();

    public Person(int i, AddressBookDto addressBookDto) {

    }

    public Person(AddressBookDto addressBookDTO) {
        this.updateAddressBookDetails(addressBookDTO);
    }

    public Person() {

    }

    public void updateAddressBookDetails(AddressBookDto addressBookDto) {
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