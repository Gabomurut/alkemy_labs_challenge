package com.Murut.Challenge.AlkemyChallenge.data;

import java.util.List;

import com.Murut.Challenge.AlkemyChallenge.model.StudentsAssignments;

import org.springframework.data.repository.CrudRepository;

public interface StudentsAssignmentsRepository extends CrudRepository<StudentsAssignments, Integer> {
    List<StudentsAssignments> findAllByOrderByAssignmentName();

    StudentsAssignments findByStudentAssignmentId(int id);

    boolean existsByStudentAssignmentIdAndStudentDni(int id, String userName);

    boolean existsByScheduleAndStudentDni(String schedule, String userName);

}
