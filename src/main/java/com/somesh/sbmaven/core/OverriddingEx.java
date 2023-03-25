package com.somesh.sbmaven.core;

class Base
{  
    void method(int a)  
    {  
        System.out.println("Base class method called with integer a = "+a);  
    }  
       
    void method(double d)  
    {  
        System.out.println("Base class method called with double d ="+d);  
    }  
}  
   
class Derived extends Base  
{  
    @Override  
    void method(double d)  
    {  
        System.out.println("Derived class method called with double d ="+d);  
    }  
}  
   
public class OverriddingEx  
{      
    public static void main(String[] args)  
    {
       Base d =  new Derived();

        d.method(10);
    }  
} 