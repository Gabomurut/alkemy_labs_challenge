package com.alkemyjavachallange.java_challange.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentsAssignments {

    @Id
    private int id;
    
    private int studentAssignmentId;
    private String studentDni;
    private String assignmentName;
    private String schedule;
    private String teacher;
    
    public int getId() {
        return id;
    }
    public String getTeacher() {
        return teacher;
    }
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getStudentAssignmentId() {
        return studentAssignmentId;
    }
    public void setStudentAssignmentId(int studentAssignmentId) {
        this.studentAssignmentId = studentAssignmentId;
    }
    public String getStudentDni() {
        return studentDni;
    }
    public void setStudentDni(String studentDni) {
        this.studentDni = studentDni;
    }
    public String getAssignmentName() {
        return assignmentName;
    }
    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }
    public String getSchedule() {
        return schedule;
    }
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
    
    @Override
    public String toString() {
        return "StudentsAssignments [assignmentName=" + assignmentName + ", id=" + id + ", schedule=" + schedule
                + ", studentAssignmentId=" + studentAssignmentId + ", studentDni=" + studentDni + ", teacher=" + teacher
                + "]";
    }
    
    

    
    
}
