package com.jpaapp.repositary;

import com.jpaapp.entities.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author YBolshakova
 */
public class StudentRepositary {
    
    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;
    private final EntityTransaction transaction = null;

    public StudentRepositary(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
        this.entityManager = entityManagerFactory.createEntityManager();
    }
    
    
    public void addStudent(){
        
    }
    
    public void updateStudent(Student student){
        
    }
    
    public  void deleteStudent(Student student){
        
    }
    
    public List<Student> findByLastname(){
        return null;
        
    }
    
    public List<Student> findByAge(int min, int max){
        return null;
        
    }
    public List<Student> findByGroup(String groupCode){
        return null;
        
    }
    

}
