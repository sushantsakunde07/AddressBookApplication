package com.bridgelabz.addressbookapplication.service;

import com.bridgelabz.addressbookapplication.dto.AddressBookDto;
import com.bridgelabz.addressbookapplication.dto.ResponseDto;
import com.bridgelabz.addressbookapplication.entity.Person;
import com.bridgelabz.addressbookapplication.exception.AddressBookException;
import com.bridgelabz.addressbookapplication.repository.AddressBookRepository;
import com.bridgelabz.addressbookapplication.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class AddressBookServiceImpl implements AddressBookService{

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private MailService mailService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AddressBookRepository addressBookRepository;
    private List<Person> list = new ArrayList<>();
    public List<Person> getAddressBookDetails(String token) {
        Long userId = jwtUtil.decodeToken(token);
        Optional<Person> isUserPresent = addressBookRepository.findById(userId);
        if (isUserPresent.isPresent()) {
            return addressBookRepository.findAll();
        }
        throw new AddressBookException("User not present");
    }
    @Override
    public Person getAddressBookDetailsById(Long personId) {
        return addressBookRepository.findById(personId)
                .orElseThrow(() -> new AddressBookException("User Not Found"));
    }

    public List<Person> getPersonByFirstName(String firstName) {
        return addressBookRepository.findByFirstName(firstName);
    }

    public List<Person> getPersonByLastName(String lastName) {
        return addressBookRepository.findByLastName(lastName);
    }

    public List<Person> getPersonByGender(String gender) {
        return addressBookRepository.findByGender(gender);
    }

    public List<Person> getPersonByAddress(String address) {
        return addressBookRepository.findByAddress(address);
    }

    public List<Person> getPersonByCity(String city) {
        return addressBookRepository.findByCity(city);
    }

    public List<Person> getPersonByState(String state) {
        return addressBookRepository.findByState(state);
    }

    public List<Person> getPersonByZipCode(String zipCode) {
        return addressBookRepository.findByZipCode(zipCode);
    }

    public List<Person> getPersonByPhoneNumber(String phoneNumber) {
        return addressBookRepository.findByPhoneNumber(phoneNumber);
    }

    public Optional<Person> getPersonByEmailId(String emailId) {
        return addressBookRepository.findByEmailId(emailId);
    }
    public Person createAddressBookDetails(AddressBookDto addressBookDTO){
        Person person = null;
        String encodedPassword = bCryptPasswordEncoder.encode(addressBookDTO.getPassword());
        addressBookDTO.setPassword(encodedPassword);
        person = new Person(addressBookDTO);
        log.debug("User Data: " +person.toString());
        String body = "Contact added successfully with Id is " + person.getPersonId();
        String subject = "Contact registration successfully";
        mailService.send(person.getEmailId(),body,subject);
        return addressBookRepository.save(person);
    }

    public Person updateAddressBookDetails(long personId ,AddressBookDto addressBookDTO){
        Person addressBookData = this.getAddressBookDetailsById(personId);
        addressBookData.updateAddressBookData(addressBookDTO);
        return addressBookRepository.save(addressBookData);
    }

    public void deleteAddressBookDetails(long personId){
        Person addressBookData = this.getAddressBookDetailsById(personId);
        addressBookRepository.delete(addressBookData);
    }

    @Override
    public ResponseDto login(String emailId, String password) {
        Optional<Person> isEmailPresent = addressBookRepository.findByEmailId(emailId);
        if (isEmailPresent.isPresent()) {
            if (bCryptPasswordEncoder.matches(password, isEmailPresent.get().getPassword())) {
                String token = jwtUtil.createToken(isEmailPresent.get().getPersonId());
                return new ResponseDto("User has logged In", 200, token);
            } else {
                throw new AddressBookException("Password wrong");
            }
        }
        throw new AddressBookException("No Contact Found");
    }
}