package com.jpaapp.repositary;

import com.jpaapp.entities.Group;
import com.jpaapp.entities.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author YBolshakova
 */
public class GroupeRepositary {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;
    private final EntityTransaction transaction = null;

    public GroupeRepositary(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void addGroup() {

    }

    public void updateGroup(Student student) {

    }

    public void deleteGroup(Student student) {

    }

    public Group findByCode(String groupCode) {
        return null;

    }

        public List<Group> selectAll() {
        return null;

    }

}
