package com.somesh.sbmaven.core;

class Person
{  
    public Person()   
    {  
        System.out.println("Person class constructor called");  
    }  
}  
public class Employee extends Person   
{  
    public Employee()   
    {  
        System.out.println("Employee class constructor called");  
    }  
    public static void main (String args[])  
    {  
        Employee e = new Employee();  
    }  
} 