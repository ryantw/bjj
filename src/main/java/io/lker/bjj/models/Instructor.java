package io.lker.bjj.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int yearsOfExperience;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor")
    private Set<Student> studentSet = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor")
    private Set<Lesson> lessons = new HashSet<>();

    public Instructor(String name, int yearsOfExperience) {
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
    }

    public Instructor(String name, int yearsOfExperience, Set<Student> studentSet) {
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.studentSet = studentSet;
    }

    public Instructor(String name, int yearsOfExperience, Set<Student> studentSet, Set<Lesson> lessons) {
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.studentSet = studentSet;
        this.lessons = lessons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }
}
