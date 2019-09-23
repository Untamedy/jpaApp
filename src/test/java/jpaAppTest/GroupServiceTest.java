/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaAppTest;

import com.jpaapp.entities.Group;
import com.jpaapp.init.Init;
import com.jpaapp.services.GroupService;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Lenovo
 */
public class GroupServiceTest extends Assert{
    
    private static EntityManagerFactory entityManagerFactory;
    private static GroupService groupService;
    private static Init init;
    private static String grPTH = "src\\main\\resources\\groups.txt";
    private static List<Group> groups;
    
    @BeforeClass
    public static void init(){
    entityManagerFactory = Persistence.createEntityManagerFactory("JpaAppPostgresql");
    groupService = new GroupService(entityManagerFactory);
    init = new Init();
    groups = init.createGroup(grPTH);  
    }
    
    @Test
    public void addGroupTest(){
    groupService.addGroup("fr_5");
        assertNotNull(groupService.findByCode("fr_5"));
    }
    
    public void updateGrouptest(){
        groupService.updateGroup("fr_5", "de_1");
        assertNotNull(groupService.findByCode("de_1"));
    }
    
    public void deleteGroupTest(){
      Group group =  groupService.findByCode("zz_2");
      if(group!=null){
        groupService.deleteGroup("zz_2");  
      }
      assertNull(groupService.findByCode("zz_2"));      
    }
    
    public void selectAllTest(){
        List<Group> all = groupService.selectAll();
        assertFalse(all.isEmpty());
    }
    
    public void findByCodeTest(){
        Group group = groupService.findByCode("ht_4");
        assertNotNull(group);
    }
    
    
}
