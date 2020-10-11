package com.jgsudhakar.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.entity.StudentEntity
 * @Date : 11/10/2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "STUDENT")
public class StudentEntity  implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The user key. */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="STU_SEQ")
    @SequenceGenerator(name="STU_SEQ",sequenceName="STU_SEQ",initialValue = 1,allocationSize = 1)
    @Column(name="STU_KEY")
    private Long id;

    @Column(name="FIRST_NAME")
    private String stuFirstName;

    @Column(name="LAST_NAME")
    private String stuLastName;

    @Column(name="ROLL_NO")
    private String stuRollNo;
}
