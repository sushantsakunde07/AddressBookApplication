package com.bridgelabz.addressbookapplication.exception;

import com.bridgelabz.addressbookapplication.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class AddressBookExceptionalHandler {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDto> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception){
        log.error("JSON parse error", exception);
        ResponseDto responseDTO = new ResponseDto("Exception while processing REST request", "array");
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream().map(objErr -> objErr.getDefaultMessage())
                .collect(Collectors.toList());
        ResponseDto responseDTO = new ResponseDto("Exception while processing REST request", errMsg);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(AddressBookException.class)
    public ResponseEntity<ResponseDto> handleAddressBookException(AddressBookException exception){
        ResponseDto responseDTO = new ResponseDto("Exception while processing REST Request",exception.getMessage());
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
