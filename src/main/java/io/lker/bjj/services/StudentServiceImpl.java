package io.lker.bjj.services;

import io.lker.bjj.models.Student;
import io.lker.bjj.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public Set<Student> getStudents() {
        Set<Student> studentSet = new HashSet<>();
        studentRepository.findAll().iterator().forEachRemaining(studentSet::add);
        return studentSet;
    }

    @Override
    public Student findById(Long l) {
        Optional<Student> student = studentRepository.findById(l);
        if(!student.isPresent()){
            throw new RuntimeException("Missing student ID.");
        }
        return student.get();
    }
}
