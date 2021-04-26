package com.Murut.Challenge.AlkemyChallenge.data;

import java.util.List;

import com.Murut.Challenge.AlkemyChallenge.model.Teacher;

import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
    List<Teacher> findAllByOrderByName();

    Teacher findByLastName(String lastName);
}
