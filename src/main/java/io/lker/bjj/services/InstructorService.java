package io.lker.bjj.services;

import io.lker.bjj.models.Instructor;

import java.util.Set;


public interface InstructorService {
    Set<Instructor> getInstructors();
    Instructor findById(Long l);
}
