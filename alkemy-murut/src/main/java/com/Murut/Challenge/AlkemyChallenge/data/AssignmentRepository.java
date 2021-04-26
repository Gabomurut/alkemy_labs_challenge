package com.Murut.Challenge.AlkemyChallenge.data;

import java.util.List;

import com.Murut.Challenge.AlkemyChallenge.model.Assignment;

import org.springframework.data.repository.CrudRepository;

public interface AssignmentRepository extends CrudRepository<Assignment, Integer> {

    List<Assignment> findAllByOrderByName();

}
