package com.jgsudhakar.spring.iface;

import com.jgsudhakar.spring.req.StudentReqDto;
import com.jgsudhakar.spring.res.StudentResDto;

import java.util.List;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.iface.StudentIFace
 * @Date : 11/10/2020
 */
public interface StudentIFace {

    public StudentResDto save(StudentReqDto studentReqDto);

    public List<StudentResDto> getStudentList();

    public StudentResDto getStudentDetails(Long id);
}
