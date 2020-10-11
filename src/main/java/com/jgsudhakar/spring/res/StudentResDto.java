package com.jgsudhakar.spring.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.res.StudentResDto
 * @Date : 09/10/2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResDto implements Serializable {

    private Long id;

    private String stuFirstName;

    private String stuLastName;

    private String stuRollNo;
}
