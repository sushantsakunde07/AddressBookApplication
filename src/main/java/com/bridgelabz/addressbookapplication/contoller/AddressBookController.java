package com.bridgelabz.addressbookapplication.contoller;

import com.bridgelabz.addressbookapplication.dto.AddressBookDto;
import com.bridgelabz.addressbookapplication.dto.ResponseDto;
import com.bridgelabz.addressbookapplication.entity.Person;
import com.bridgelabz.addressbookapplication.service.AddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addressbookservice")
@Slf4j
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDto> getAddressBookData(@RequestHeader String token){
        List<Person> personList = null;
        personList = addressBookService.getAddressBookDetails(token);
        ResponseDto responseDTO = new ResponseDto("Get Call Success", 200,personList);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/get/{personId}")
    
    public ResponseEntity<ResponseDto> getAddressBookData(@RequestHeader String token, @PathVariable("personId")long personId){
        Person addressBookData = null;
        addressBookData = addressBookService.getAddressBookDetailsById(personId);
        ResponseDto responseDTO = new ResponseDto("Get Call For Id Successful!!", 200,addressBookData);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);    }

    @RequestMapping("/firstName")
    public ResponseEntity<ResponseDto> getPersonByFirstName(@RequestHeader String token, @RequestParam String firstName) {
        List<Person> addressBookDataList = null;
        addressBookDataList = addressBookService.getPersonByFirstName(firstName);
        ResponseDto responseDTO = new ResponseDto("Request Call For First Name Successfully", 200,addressBookDataList);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
    }

    @RequestMapping("/lastName")
    public ResponseEntity<ResponseDto> getPersonByLastName(@RequestHeader String token,@RequestParam String lastName) {
        List<Person> addressBookDataList = null;
        addressBookDataList = addressBookService.getPersonByLastName(lastName);
        ResponseDto responseDTO = new ResponseDto("Request Call For Last Name Successfully", 200,addressBookDataList);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
    }

    @RequestMapping("/gender")
    public ResponseEntity<ResponseDto> getPersonByGender(@RequestHeader String token, @RequestParam String gender) {
        List<Person> addressBookDataList = null;
        addressBookDataList = addressBookService.getPersonByGender(gender);
        ResponseDto responseDTO = new ResponseDto("Request Call For Gender Successfully", 200,addressBookDataList);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
    }
    @RequestMapping("/address")
    public ResponseEntity<ResponseDto> getPersonByAddress(@RequestHeader String token,@RequestParam String address) {
        List<Person> addressBookDataList = null;
        addressBookDataList = addressBookService.getPersonByAddress(address);
        ResponseDto responseDTO = new ResponseDto("Request Call For Address Successfully",200, addressBookDataList);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
    }
    @RequestMapping("/city")
    public ResponseEntity<ResponseDto> getPersonByCity(@RequestHeader String token,@RequestParam String city) {
        List<Person> addressBookDataList = null;
        addressBookDataList = addressBookService.getPersonByCity(city);
        ResponseDto responseDTO = new ResponseDto("Request Call For City Successfully", 200,addressBookDataList);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
    }

    @RequestMapping("/state")
    public ResponseEntity<ResponseDto> getPersonByState(@RequestHeader String token,@RequestParam String state) {
        List<Person> addressBookDataList = null;
        addressBookDataList = addressBookService.getPersonByState(state);
        ResponseDto responseDTO = new ResponseDto("Request Call For State Successfully", 200,addressBookDataList);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
    }

    @RequestMapping("/zipCode")
    public ResponseEntity<ResponseDto> getPersonByZipCode(@RequestParam String zipCode) {
        List<Person> addressBookDataList = null;
        addressBookDataList = addressBookService.getPersonByZipCode(zipCode);
        ResponseDto responseDTO = new ResponseDto("Request Call For ZipCode Successfully", 200,addressBookDataList);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
    }

    @RequestMapping("/phoneNumber")
    public ResponseEntity<ResponseDto> getPersonByPhoneNumber(@RequestParam String phoneNumber) {
        List<Person> addressBookDataList = null;
        addressBookDataList = addressBookService.getPersonByPhoneNumber(phoneNumber);
        ResponseDto responseDTO = new ResponseDto("Request Call For Phone Number Successfully", 200,addressBookDataList);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
    }

    @RequestMapping("/emailId")
    public ResponseEntity<ResponseDto> getPersonByEmailId(@RequestParam String emailId) {
        Optional<Person> addressBookDataList = null;
        addressBookDataList = addressBookService.getPersonByEmailId(emailId);
        ResponseDto responseDTO = new ResponseDto("Request Call For EmailId Successfully", 200,addressBookDataList);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> addAddressBookData(@Valid @RequestBody AddressBookDto addressBookDTO){
        log.debug("User Dto: " +addressBookDTO.toString());
        Person addressBookData = null;
        addressBookData = addressBookService.createAddressBookDetails(addressBookDTO);
        ResponseDto responseDTO = new ResponseDto("Created Address Book Data Successfully: ", 200,addressBookData);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);    }

    @PutMapping("/update/{personId}")
    public ResponseEntity<ResponseDto> updateAddressBookData(@PathVariable("personId") Long personId, @Valid @RequestBody AddressBookDto addressBookDTO){
        Person addressBookData = null;
        addressBookData = addressBookService.updateAddressBookDetails(personId, addressBookDTO);
        ResponseDto responseDTO = new ResponseDto("Updated Address Book Data Successfully:", 200,addressBookData);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);    }

    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<ResponseDto> deleteAddressBookData(@PathVariable("personId")long personId){
        addressBookService.deleteAddressBookDetails(personId);
        ResponseDto responseDTO = new ResponseDto("Address Book Data Deleted Successfully: ",200, "Delete Id:" +personId);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseDto loginAddressBook(@RequestParam String emailId, @RequestParam String password){
        return addressBookService.login(emailId,password);
    }
}