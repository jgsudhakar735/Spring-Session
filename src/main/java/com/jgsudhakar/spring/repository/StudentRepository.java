package com.jgsudhakar.spring.repository;

import com.jgsudhakar.spring.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.repository.StudentRepository
 * @Date : 11/10/2020
 */
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long>, JpaSpecificationExecutor<StudentEntity> {
}
