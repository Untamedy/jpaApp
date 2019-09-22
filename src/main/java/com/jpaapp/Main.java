/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpaapp;

import com.jpaapp.entities.Group;
import com.jpaapp.entities.Student;
import com.jpaapp.services.GroupService;
import com.jpaapp.services.StudentService;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lenovo
 */
public class Main {

    public static void main(String[] args) {       

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JpaAppMySql");
        StudentService studentService = new StudentService(factory);
        GroupService groupService = new GroupService(factory);

       
         studentService.addStudent("Jack", "Black", 18);
        groupService.addGroup("rr_1");
        groupService.addGroup("aa_1");
       

      /*  studentService.setGroupToStudent("Black", "Jack", "aa_1");
        List<Student> studentsAge = studentService.findByAge(12, 20);
        studentsAge.forEach((s) -> {
            System.out.println(s.toString());
        });

        List<Student> studentsGroup = studentService.findByGroup("rr_1");
        studentsAge.forEach((s) -> {
            System.out.println(s.toString());
        });

        List<Student> studentsLastname = studentService.findByLastname("Black");
        studentsLastname.forEach((s) -> {
            System.out.println(s.toString());
        });

        groupService.updateGroup("rr_1", "ss_1");
        groupService.deleteGroup("ss_1");

        Group group = groupService.findByCode("aa_1");
        System.out.println(group.toString());

        List<Group> groups = groupService.selectAll();
        groups.forEach((g) -> {
            System.out.println(g.toString());
        });*/

    }

}
