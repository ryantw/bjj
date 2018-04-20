package io.lker.bjj.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int hours;
    private Date date;

    @OneToOne(cascade = CascadeType.ALL)
    private LessonNotes lessonNotes;

    @ManyToOne
    private Instructor instructor;

    public Lesson(int hours, Date date, LessonNotes lessonNotes, Instructor instructor) {
        this.hours = hours;
        this.date = date;
        this.lessonNotes = lessonNotes;
        this.instructor = instructor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LessonNotes getLessonNotes() {
        return lessonNotes;
    }

    public void setLessonNotes(LessonNotes lessonNotes) {
        this.lessonNotes = lessonNotes;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
