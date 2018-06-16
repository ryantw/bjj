package io.lker.bjj.bootstrap;

import io.lker.bjj.models.*;
import io.lker.bjj.repositories.InstructorRepository;
import io.lker.bjj.repositories.StudentRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
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
        Instructor instructor = new Instructor("Joe Test", 2);
        instructors.add(instructor);

        return instructors;
    }

    private List<Student> getStudents(){
        List<Student> students = new ArrayList<>(2);
        Lesson lessonOne = new Lesson();
        LessonNotes lessonOneNotes = new LessonNotes();
        lessonOneNotes.setLesson(lessonOne);
        lessonOneNotes.setNotes("Half-guard stuff.");
        lessonOne.setDate(new Date());
        lessonOne.setHours(2);
        lessonOne.setLessonNotes(lessonOneNotes);
        Student student = new Student();
        student.setName("Ryan W");
        student.setYearsOfExperience(5);
        student.setInstructor(null);
        student.setLessons(lessonOne);
        student.setBeltRank(BeltRank.BLUE3);
        lessonOne.setStudent(student);

        Lesson lessonTwo = new Lesson();
        LessonNotes lessonTwoNotes = new LessonNotes();
        lessonTwoNotes.setLesson(lessonTwo);
        lessonTwoNotes.setNotes("Punching face stuff.");
        lessonTwo.setDate(new Date());
        lessonTwo.setHours(3);
        lessonTwo.setLessonNotes(lessonTwoNotes);
        Student student2 = new Student();
        student2.setName("J-Funk");
        student2.setYearsOfExperience(4);
        student2.setInstructor(null);
        student2.setLessons(lessonTwo);
        student2.setBeltRank(BeltRank.WHITE4);
        lessonTwo.setStudent(student2);

        //student.setLessons(lessonTwo);
        //lessonTwo.setStudent(student);

        students.add(student);
        students.add(student2);
        return students;
    }
}
