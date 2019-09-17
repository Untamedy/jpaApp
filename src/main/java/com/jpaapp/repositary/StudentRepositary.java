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
    private EntityTransaction transaction = null;

    public StudentRepositary(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void addStudent(Student student) {
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(student);
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();

            }
        }
    }

    public void updateStudent(Student student) {        
        try {
            transaction = entityManager.getTransaction();           
            transaction.begin();
            entityManager.persist(student);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();

            }
        }

    }

    public void deleteStudent(Student student) {
       try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(student);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }  
    }

    public List<Student> findByLastname(String lastname) {
        return null;

    }

    public List<Student> findByAge(int min, int max) {
        return null;

    }

    public List<Student> findByGroup(String groupCode) {
        return null;

    }

    public List<Student> findByLastname(Student lastname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
