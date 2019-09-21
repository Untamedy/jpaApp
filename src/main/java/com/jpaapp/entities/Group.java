/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpaapp.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "groups")
public class Group {

    public Group() {
    }

    public Group(String code, List<Student> students) {
        this.code = code;
        this.students = students;
    }

    public Group(String code) {
        this.code = code;
    }
    
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column
    private String code;
    
   @OneToMany(mappedBy = "group", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Student> students;

    public int getId() {
        return id;
    }

    public List<Student> getStudents() {
        return students;
    }
  
   
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group{" + "id=" + id + ", code=" + code + ", students=" + students + '}';
    }
     
    
    
}
