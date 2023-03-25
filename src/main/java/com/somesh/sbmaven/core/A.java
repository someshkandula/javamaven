package com.somesh.sbmaven.core;

class A{
A get(){return this;}
}

class Covariant extends A{
Covariant get(){return this;}
void message(){System.out.println("welcome to covariant return type");}

public static void main(String args[]){
new Covariant().get().message();
}
}