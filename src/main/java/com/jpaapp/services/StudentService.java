package com.jpaapp.services;

import com.jpaapp.entities.Group;
import com.jpaapp.entities.Student;
import com.jpaapp.repositary.GroupeRepositary;
import com.jpaapp.repositary.StudentRepositary;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author YBolshakova
 */
public class StudentService {

    private EntityManagerFactory managerFactory;
    private StudentRepositary studentRepositary;
    private GroupeRepositary groupeService;

    public StudentService() {
    }

    public StudentService(EntityManagerFactory managerFactory) {
        this.managerFactory = managerFactory;
        this.studentRepositary = new StudentRepositary(managerFactory);
        this.groupeService = new GroupeRepositary(managerFactory);
    }

    public void addStudent(String name, String lastname, int age) {
        Student student = new Student(name, lastname, age);
        studentRepositary.addStudent(student);
    }

    public void setGroupToStudent(String lastname, String name, String groupCode) {
        Student student = getStudent(lastname, name);
        if (student != null) {
            Group group = groupeService.findByCode(groupCode);
            student.setGroup(group);
            studentRepositary.updateStudent(student);
        }
    }

    public void deleteStudent(String lastname, String name, String groupCode) {
        List<Student> students = (List<Student>) studentRepositary.findByLastname(lastname);
        Group group = groupeService.findByCode(groupCode);
        for (Student s : students) {
            if ((s.getName().equals(name)) && (s.getGroup().getCode().equals(groupCode))) {
                studentRepositary.deleteStudent(s);
            }
        }
    }

    public List<Student> findByLastname(String lastname) {
        List<Student> students = studentRepositary.findByLastname(lastname);
        return students;
    }

    public List<Student> findByAge(int min, int max) {
        List<Student> students = studentRepositary.findByAge(min, max);
        return students;
    }

    public List<Student> findByGroup(String groupCode) {
        Group group = groupeService.findByCode(groupCode);
        List<Student> students = studentRepositary.findByGroup(group.getId());
        return students;
    }

    public Student getStudent(String lastname, String name) {
        Student student = null;
        List<Student> students = (List<Student>) studentRepositary.findByLastname(lastname);
        for (Student s : students) {
            if (s.getName().equals(name)) {
                return student = s;
            }
        }
        return student;
    }

}
