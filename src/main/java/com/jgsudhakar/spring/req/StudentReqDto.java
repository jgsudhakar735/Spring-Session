package com.jgsudhakar.spring.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.req.StudentReqDto
 * @Date : 09/10/2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentReqDto implements Serializable {

    private Long id;

    private String stuFirstName;

    private String stuLastName;

    private String stuRollNo;

}
