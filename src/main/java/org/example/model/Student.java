package org.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student", schema = "jeswin")
public class Student {
    @Id
    @Column(name="ID")
    int id;
    @Column(name="Name")
    String name;
    @Column(name="STD")
    int std;
    @Column(name="DOB")
    Date dob;
    @Column(name="course_ID")
    int courseID;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "course_ID", referencedColumnName = "course_id",insertable = false, updatable = false)
    private Course course;

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

    public int getStd() {
        return std;
    }

    public void setStd(int std) {
        this.std = std;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
