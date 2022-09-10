package com.bridgelabz.addressbookapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public @Data class ResponseDto {
    private String message;
    private int statusCode;
    private Object data;

}