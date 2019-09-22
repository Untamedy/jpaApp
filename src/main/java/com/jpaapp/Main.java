/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpaapp;

import com.jpaapp.entities.Group;
import com.jpaapp.entities.Student;
import com.jpaapp.init.Init;
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

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JpaAppPostgresql");
        StudentService studentService = new StudentService(factory);
        GroupService groupService = new GroupService(factory);
        
        
        String stPath = "src\\main\\resources\\students.txt";
        String grPTH = "src\\main\\resources\\groups.txt";
        
        Init init = new Init();
        List<Student> st = init.createStudent(stPath);
        List<Group> gr = init.createGroup(grPTH);
        
        st.forEach((s)->{
            studentService.addStudent(s.getName(), s.getLastname(), s.getAge());
        });
        
        gr.forEach((g)->{
            groupService.addGroup(g.getCode());
        });
        
        List<Student> allStudents = studentService.selectAll();
        allStudents.forEach((s)->{
            if(s.getId()<=5){
                studentService.setGroupToStudent(s.getLastname(), s.getName(), "qq_1");
            }
            if(s.getId()>5&&s.getId()<10){
                studentService.setGroupToStudent(s.getLastname(), s.getName(), "tt_2"); 
            }
            if(s.getId()>10&&s.getId()<=15){
                studentService.setGroupToStudent(s.getLastname(), s.getName(), "zz_2");
            }
            if(s.getId()>15){
                 studentService.setGroupToStudent(s.getLastname(), s.getName(), "ht_4");
            }
        });
        
        

        groupService.addGroup("rr_1");
        groupService.addGroup("aa_1");
        groupService.addGroup("kk_1");
        studentService.addStudent("Jack", "Black", 18);

      studentService.setGroupToStudent("Black", "Jack", "aa_1");
          List<Student> studentsAge = studentService.findByAge(12, 20);
        studentsAge.forEach((s) -> {
            System.out.println(s.toString());
        });

       List<Student> studentsGroup = studentService.findByGroup("rr_1");
        studentsGroup.forEach((s) -> {
            System.out.println(s.toString());
        });
        
        groupService.updateGroup("aa_1", "gg_1");

        List<Student> studentsLastname = studentService.findByLastname("Black");
        studentsLastname.forEach((s) -> {
            System.out.println("By lastname - " + s.toString());
        });

        groupService.updateGroup("rr_1", "ss_1");
        
        groupService.deleteGroup("ss_1");

        Group group = groupService.findByCode("aa_1");    
        if(group!=null){
            System.out.println("Group by code-" + group.toString());
        }

        List<Group> groups = groupService.selectAll();
        groups.forEach((g) -> {
            System.out.println("All groups - "+ g.toString());
        });

    }

}
