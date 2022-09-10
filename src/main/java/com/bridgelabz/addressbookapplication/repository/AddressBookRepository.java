package com.bridgelabz.addressbookapplication.repository;

import com.bridgelabz.addressbookapplication.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressBookRepository extends JpaRepository<Person, Long> {

    List<Person> findByFirstName(String firstName);

    List<Person> findByLastName(String lastName);

    List<Person> findByGender(String gender);

    List<Person> findByAddress(String address);

    List<Person> findByCity(String city);

    List<Person> findByState(String state);

    List<Person> findByZipCode(String zipCode);

    List<Person> findByPhoneNumber(String phoneNumber);

    Optional<Person> findByEmailId(String emailId);

}