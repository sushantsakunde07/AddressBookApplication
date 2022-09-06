package com.bridgelabz.addressbookapplication.contoller;

import com.bridgelabz.addressbookapplication.dto.AddressBookDto;
import com.bridgelabz.addressbookapplication.dto.ResponseDto;
import com.bridgelabz.addressbookapplication.entity.Person;
import com.bridgelabz.addressbookapplication.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController

@RequestMapping("/addressbookservice")
public class AddressBookController {
    @Valid
    @Autowired
    private AddressBookService addressBookService;

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDto> getAddressBookDetails() {
        Person person = null;
        List<Person> personList = addressBookService.getAddressBookDetails();
        ResponseDto responseDto = new ResponseDto("Get Call Success", personList);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/get/{personId}")
    public ResponseEntity<ResponseDto> getAddressBookDetailsById(@PathVariable Long personId) {
        Person person = null;
        person = addressBookService.getAddressDetailsById(personId);
        ResponseDto responseDto = new ResponseDto("Get call success for ID", person);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAddressBookDetails(@Valid @RequestBody AddressBookDto addressBookDto) {
        Person person = null;
        person = addressBookService.createAddressBookDetails(addressBookDto);
        ResponseDto responseDto = new ResponseDto("Post call success for Create", person);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> updateAddressBookDetails(@PathVariable("id") Long personId, @Valid @RequestBody AddressBookDto addressBookDto) {
        Person person = null;
        person = addressBookService.updateAddressBookDetails(personId, addressBookDto);
        ResponseDto responseDto = new ResponseDto("Updates Address Book data successfully !", person);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddressBookDetails(@PathVariable("id") Long personId) {
        addressBookService.deleteAddressDetails(personId);
        return new ResponseEntity<>("Deleted Address Book Data Successfully !", HttpStatus.OK);
    }
}