package com.alkemyjavachallange.java_challange.data;

import java.util.List;

import com.alkemyjavachallange.java_challange.model.StudentsAssignments;

import org.springframework.data.repository.CrudRepository;

public interface StudentsAssignmentsRepository extends CrudRepository<StudentsAssignments, Integer> {
    List<StudentsAssignments> findAllByOrderByAssignmentName();

    StudentsAssignments findByStudentAssignmentId(int id);

    boolean existsByStudentAssignmentIdAndStudentDni(int id, String userName);

    boolean existsByScheduleAndStudentDni(String schedule, String userName);

}
