package com.bridgelabz.addressbookapplication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


import javax.validation.constraints.*;


public @Data class AddressBookDto {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "User's first name is Invalid")
    public String firstName;
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "User's last name is Invalid")
    public String lastName;
    @Pattern(regexp = "male|female", message = "Gender needs to be male or female")
    public String gender;
    @NotBlank(message = "Address cannot be Empty")
    public String address;
    @Pattern(regexp = "^[A-Z][a-z]+$", message = "City Name is Invalid")
    public String city;
    @Pattern(regexp = "^[A-Z][a-z]+[\\s[A-Z][a-z]+]*$", message = "State Name is Invalid")
    public String state;
    @Pattern(regexp = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$", message = "Zip Code Is Invalid")
    public String zipCode;
    @Pattern(regexp = "^[789][0-9]{9}$", message = "Phone Number Is Invalid")
    public String phoneNumber;
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",flags = Pattern.Flag.CASE_INSENSITIVE,message = "Email Id Is Invalid")
    public String emailId;

}
