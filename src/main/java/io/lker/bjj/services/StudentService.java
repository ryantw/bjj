package io.lker.bjj.services;

import io.lker.bjj.models.Student;

import java.util.Set;

public interface StudentService {
    Set<Student> getStudents();
    Student findById(Long l);
}
