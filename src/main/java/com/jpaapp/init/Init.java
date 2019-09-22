package com.jpaapp.init;

import com.jpaapp.entities.Group;
import com.jpaapp.entities.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class Init {

   
    public String parsCSV(String path) {
        StringBuilder objects = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path));) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                objects.append(line);
                objects.append(";");
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Init.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Init.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objects.toString();
    }

    public String[] splitData(String data) {
        return data.split(";");
    }

    public List<Student> createStudent(String path) {
        List<Student> students = new ArrayList<>();
        String data = parsCSV(path);
        String[] studentsData = splitData(data);
        for (String s : studentsData) {
            String[] stData = s.split(",");
            Student student = new Student();
            student.setName(stData[0]);
            student.setLastname(stData[1]);
            student.setAge(Integer.valueOf(stData[2]));
            students.add(student);
        }
        return students;
    }
    
    public List<Group> createGroup(String path){
         List<Group> groups = new ArrayList<>();
        String data = parsCSV(path);
        String[] groupData = splitData(data);
        for (String s : groupData) {            
            Group group = new Group();
            group.setCode(s);           
            groups.add(group);
        }
        return groups;        
    }
    

}
