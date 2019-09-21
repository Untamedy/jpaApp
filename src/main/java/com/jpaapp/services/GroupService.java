/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpaapp.services;

import com.jpaapp.entities.Group;
import com.jpaapp.repositary.GroupeRepositary;
import com.jpaapp.repositary.StudentRepositary;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Lenovo
 */
public class GroupService {

    

    private EntityManagerFactory managerFactory;
    private StudentRepositary studentService;
    private GroupeRepositary groupeRepositary;

    public GroupService() {
    }

    public GroupService(EntityManagerFactory managerFactory) {
        this.managerFactory = managerFactory;
        this.studentService = new StudentRepositary(managerFactory);
        this.groupeRepositary = new GroupeRepositary(managerFactory);
    }

    public void addGroup(String code) {
        Group group = groupeRepositary.findByCode(code);
        if (group == null) {
            groupeRepositary.addGroup(group);
        }
    }

    public void updateGroup(String oldCode, String newCode) {
        Group group = groupeRepositary.findByCode(oldCode);
        if (group != null) {
            groupeRepositary.updateGroup(group, newCode);
        }
    }

    public void deleteGroup(String groupCode) {
        Group group = groupeRepositary.findByCode(groupCode);
        if (group != null) {
            groupeRepositary.deleteGroup(group);
        }
    }

    public Group findByCode(String groupCode) {  
        Group group = groupeRepositary.findByCode(groupCode);        
        return group ;
    }

    public List<Group> selectAll() {
        List<Group> groups = groupeRepositary.selectAll();
        return groups;
    }

}
