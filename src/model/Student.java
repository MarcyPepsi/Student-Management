/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import tools.Tools;

/**
 *
 * @author Marcy GADEU
 */
public class Student implements Comparable<Student>, Serializable{
   private String refNumber;
   private String name;
   private int phoneNumber;
   private String program;
   private String level;
   private String address;
   private String department;

    public Student() {
    }

    public Student(String refNumber, String name, int phoneNumber, String program, String level, String address, String department) {
        this.refNumber = refNumber;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.program = program;
        this.level = level;
        this.address = address;
        this.department = department;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.refNumber);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.refNumber, other.refNumber)) {
            return false;
        }
        return true;
    }
    

    @Override
    public int compareTo(Student o) {
        return refNumber.compareToIgnoreCase(o.refNumber);
    }

    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
     public ArrayList<Student> getStudent() {
        return Tools.database;
    }

   

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
   
    
}
