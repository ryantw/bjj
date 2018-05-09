package io.lker.bjj.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int yearsOfExperience;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Set<Lesson> lessons = new HashSet<>();

    @ManyToOne
    private Instructor instructor;

    public Student() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Lesson lesson) {
        this.lessons.add(lesson);
    }
}
