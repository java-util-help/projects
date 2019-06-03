/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg1;

/**
 *
 * @author MEDİA MARKT
 */
public class Customer {
    
    private String name;
    private String surname;
    private int age;
    private String job;
    
    public Customer (String name,String surname,int age, String job){
        
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.job = job;  
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }
    
    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }
    
    public String getJob(){
        return job;
    }

    public void setJob(String job){
        this.job = job;
    }
    
    
    
}
 