package com.jgsudhakar.spring.mapper;

import com.jgsudhakar.spring.entity.StudentEntity;
import com.jgsudhakar.spring.req.StudentReqDto;
import com.jgsudhakar.spring.res.StudentResDto;
import org.springframework.stereotype.Component;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.mapper.StudentMapper
 * @Date : 11/10/2020
 */
@Component
public class StudentMapper {

    public StudentEntity convertToDBEntity(StudentReqDto studentReqDto){
        StudentEntity  studentEntity = new StudentEntity();
        if(null != studentReqDto.getId())
            studentEntity.setId(studentReqDto.getId());

        studentEntity.setStuFirstName(studentReqDto.getStuFirstName());
        studentEntity.setStuLastName(studentReqDto.getStuLastName());
        studentEntity.setStuRollNo(studentReqDto.getStuRollNo());
        return studentEntity;
    }

    public StudentResDto convertFromDBEntity(StudentEntity studentEntity){
        StudentResDto studentResDto = new StudentResDto();
        studentResDto.setStuFirstName(studentEntity.getStuFirstName());
        studentResDto.setStuLastName(studentEntity.getStuLastName());
        studentResDto.setStuRollNo(studentEntity.getStuRollNo());
        studentResDto.setId(studentEntity.getId());
        return studentResDto;
    }
}
