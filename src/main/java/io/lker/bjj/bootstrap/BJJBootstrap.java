package io.lker.bjj.bootstrap;

import io.lker.bjj.models.Instructor;
import io.lker.bjj.models.Student;
import io.lker.bjj.repositories.InstructorRepository;
import io.lker.bjj.repositories.StudentRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BJJBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final StudentRepository studentRepository;
    private final InstructorRepository instructorRepository;

    public BJJBootstrap(StudentRepository studentRepository, InstructorRepository instructorRepository) {
        this.studentRepository = studentRepository;
        this.instructorRepository = instructorRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        instructorRepository.saveAll(getInstructors());
        studentRepository.saveAll(getStudents());

    }

    private List<Instructor> getInstructors(){
        List<Instructor> instructors = new ArrayList<>(1);

        return instructors;
    }

    private List<Student> getStudents(){
        List<Student> students = new ArrayList<>(2);



        return students;
    }
}
