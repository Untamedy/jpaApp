package com.jpaapp.repositary;

import com.jpaapp.entities.Student;
import java.util.ArrayList;
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
        List<Student> students = new ArrayList<>();
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            students = entityManager.createQuery("SELECT s FROM students s where s.lastname=" + lastname).getResultList();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return students;
    }

    public List<Student> findByAge(int min, int max) {
        List<Student> students = new ArrayList<>();
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            students = entityManager.createQuery("SELECT s FROM students s WHERE s.age>" + min + " AND s.age<" + max).getResultList();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return students;
    }

    public List<Student> findByGroup(int id) {
        List<Student> students = new ArrayList<>();
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            students = entityManager.createQuery("SELECT s FROM students s where s.group_id=" + id).getResultList();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return students;
    }

}
