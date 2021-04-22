package com.alkemyjavachallange.java_challange.data;

import java.util.List;

import com.alkemyjavachallange.java_challange.model.Teacher;

import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Integer>{
    List<Teacher> findAllByOrderByName();
    Teacher findByLastName(String lastName);
}
