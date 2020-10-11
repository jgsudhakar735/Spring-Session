package com.jgsudhakar.spring.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.exception.ErrorRes
 * @Date : 11/10/2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorRes implements Serializable {

    private String code;

    private String message;

    private HttpStatus httpStatus;
}
