package org.example.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;

@Stateless
public class StudentAndCourseService {
    @PersistenceContext(unitName = "jeswin")
    EntityManager entityManager;
    public void saveCourse(int courseId, String courseName, int years){

        Course newCourse = new Course();
        newCourse.setCourseId(courseId);
        newCourse.setCourseName(courseName);
        newCourse.setYears(years);

        Student student1 =new Student();
        student1.setId(4);
        student1.setName("merlin");
        student1.setStd(12);
        student1.setDob(new Date());
        student1.setCourseID(1);

        Student student2 =new Student();
        student2.setId(5);
        student2.setName("shal");
        student2.setStd(12);
        student2.setDob(new Date());
        student2.setCourseID(1);

        ArrayList<Student> listStudents=new ArrayList<>();
        listStudents.add(student1);
        listStudents.add(student2);

        newCourse.setStudent(listStudents);

        entityManager.persist(newCourse);
        entityManager.flush();

    }

    public Persons getPersonAndInsurance(int id){
        Persons object1 = entityManager.find(Persons.class,id);
        return object1;
    }

    public Persons updatePersonAndInsurance(int id, String firstName){
        Persons object2 = entityManager.find(Persons.class,id);
        object2.setFirstName(firstName);
        entityManager.merge(object2);
        return object2;
    }

    public boolean deletePersonAndInsurance(int id){
        Persons object3 = entityManager.find(Persons.class,id);
        if (object3!=null){
            entityManager.remove(object3);
            return true;
        }else {
            return false;
        }
    }

}
