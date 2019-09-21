package com.jpaapp.repositary;

import com.jpaapp.entities.Group;
import java.util.ArrayList;
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
    private EntityTransaction transaction = null;

    public GroupeRepositary(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void addGroup(Group group) {
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(group);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void updateGroup(Group group, String newData) {
        try {
            transaction = entityManager.getTransaction();
            if (group != null) {
                group.setCode(newData);
                transaction.begin();
                entityManager.persist(group);
                transaction.commit();
            }
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void deleteGroup(Group group) {
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(group);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public Group findByCode(String groupCode) {
        Group group = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            group = (Group) entityManager.createQuery("SELECT s FROM groups g WHERE g.code=" + groupCode).getSingleResult();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return group;
    }

    public List<Group> selectAll() {
        List<Group> groups = new ArrayList<>();
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            groups = entityManager.createQuery("SELECT g FROM groups AS g",Group.class).getResultList();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return groups;     
    }
}
