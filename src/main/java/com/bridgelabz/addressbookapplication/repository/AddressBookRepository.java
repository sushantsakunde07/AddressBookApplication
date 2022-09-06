package com.bridgelabz.addressbookapplication.repository;

import com.bridgelabz.addressbookapplication.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<Person, Long> {

}