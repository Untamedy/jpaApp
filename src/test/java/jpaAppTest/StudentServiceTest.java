/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaAppTest;

import com.jpaapp.entities.Student;
import com.jpaapp.init.Init;
import com.jpaapp.services.GroupService;
import com.jpaapp.services.StudentService;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Lenovo
 */
public class StudentServiceTest {

    private static EntityManagerFactory entityManagerFactory;
    private static StudentService studentService;
    private static Init init;
    private static String stPath = "src\\main\\resources\\students.txt";
    private static List<Student> students;
    private static GroupService groupService;

    @BeforeClass
    public static void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("JpaAppMySql");
        studentService = new StudentService(entityManagerFactory);
        init = new Init();        
        groupService = new GroupService(entityManagerFactory);
        groupService.addGroup("kk_2");
         students = init.createStudent(stPath);
     students.forEach((s)->{
     studentService.addStudent(s.getName(),s.getLastname(),s.getAge());
     studentService.setGroupToStudent(s.getLastname(), s.getName(), "kk_2"); 
     });
        
    }
    
    @Test
    public void addStudenttest() {
        studentService.addStudent("Jack", "Test", 25);
        studentService.addStudent("Jill", "Test2", 21);
        List<Student> studentList = studentService.findByLastname("Test");
        assertNotNull(studentList.get(0).equals("Test"));

    }

    @Test
    public void updateTest() {
        studentService.setGroupToStudent("Test", "Jack", "kk_2");
        studentService.setGroupToStudent("Test2", "Jill", "kk_2");
        List<Student> st = studentService.findByLastname("Test");
        Student s = st.get(0);
        assertTrue(s.getGroup().getCode().equals("kk_2"));

    }

    @Test
    public void findByAge() {
        List<Student> st = studentService.findByAge(23, 25);
        assertTrue(st.size() == 1);
    }

    @Test
    public void findByLastnameTest() {
        List<Student> st = studentService.findByLastname("Test2");
        assertTrue(st.get(0).getLastname().equals("Test2"));
    }

    @Test
    public void findByGroupTest() {
        List<Student> st = studentService.findByGroup("kk_2");
        String groupCode = st.get(0).getGroup().getCode();
        assertTrue(groupCode.equals("kk_2"));
    }

    @Test
    public void deleteTest() {
        studentService.deleteStudent("Test", "Jack", "kk_2");
        assertTrue(studentService.findByLastname("Test").isEmpty());
    }

}
