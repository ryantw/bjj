package io.lker.bjj.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Academy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private Set<Instructor> academyInstructors = new HashSet<>();

    @OneToMany
    private Set<Student> academyStudents = new HashSet<>();

    private String name;

    private String phoneNumber;

    private String address;

}
