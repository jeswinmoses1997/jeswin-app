package org.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course", schema = "jeswin")
public class Course {
    @Id
    @Column(name="course_id")
    int courseId;
    @Column(name="course_name")
    String courseName;
    @Column(name="number_of_years")
    int years;
    @JsonManagedReference
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Student> student;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }
}
