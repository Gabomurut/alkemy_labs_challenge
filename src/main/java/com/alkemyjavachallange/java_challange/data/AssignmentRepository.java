package com.alkemyjavachallange.java_challange.data;

import java.util.List;

import com.alkemyjavachallange.java_challange.model.Assignment;

import org.springframework.data.repository.CrudRepository;

public interface AssignmentRepository extends CrudRepository<Assignment, Integer>{

    List<Assignment> findAllByOrderByName();
    
}
