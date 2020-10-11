package com.jgsudhakar.spring.iface.impl;

import com.jgsudhakar.spring.entity.StudentEntity;
import com.jgsudhakar.spring.iface.StudentIFace;
import com.jgsudhakar.spring.mapper.StudentMapper;
import com.jgsudhakar.spring.repository.StudentRepository;
import com.jgsudhakar.spring.req.StudentReqDto;
import com.jgsudhakar.spring.res.StudentResDto;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.iface.impl.StudentIFaceImpl
 * @Date : 11/10/2020
 */
@Service
public class StudentIFaceImpl implements StudentIFace {

    private StudentRepository studentRepository;

    private StudentMapper studentMapper;

    public StudentIFaceImpl (StudentRepository studentRepository,StudentMapper studentMapper){
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public StudentResDto save(StudentReqDto studentReqDto) {
        StudentEntity studentEntity = studentMapper.convertToDBEntity(studentReqDto);
        StudentEntity save = studentRepository.save(studentEntity);
        return studentMapper.convertFromDBEntity(save);
    }

    @Override
    public List<StudentResDto> getStudentList() {
        return Optional.ofNullable(studentRepository.findAll()).
                orElse(Collections.emptyList()).
                stream().map(stuEnt -> studentMapper.convertFromDBEntity(stuEnt)).
                collect(Collectors.toList());
    }

    @Override
    public StudentResDto getStudentDetails(Long id) {
        Optional<StudentEntity> stuRcd = studentRepository.findById(id);
        if(stuRcd.isPresent())
            return studentMapper.convertFromDBEntity(stuRcd.get());

        return null;
    }
}
