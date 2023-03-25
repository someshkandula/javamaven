package com.somesh.sbmaven.streams;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MethodRefDemo {
    public static void main(String[] args) {

        StreamObjectEx se = new StreamObjectEx ();

        // Anonymous Implementation
        se.loadEmployeesFromDB ()
                .forEach (new Consumer<Employees> () {
                    @Override
                    public void accept(Employees employees) {
                        System.out.println (employees);
                    }
                });

        System.out.println ("===============");

        // Lambda Expression
        se.loadEmployeesFromDB ()
                .forEach (employee -> System.out.println (employee)
                    );

        System.out.println ("===============");
        // Method Reference

        // Static Method Reference ClassName::method
        se.loadEmployeesFromDB ()
                .forEach (MethodRefDemo::print);

        System.out.println ("===============");
        // Method Reference
        se.loadEmployeesFromDB ().forEach (System.out::println);

        System.out.println ("===============");




        final List<EmployeeDTO> collect = se.loadEmployeesFromDB ()
                .stream ()
                .map (new Function<Employees, EmployeeDTO> () {
                    @Override
                    public EmployeeDTO apply(Employees employees) {
                        EmployeeDTO employeeDTO = new EmployeeDTO ();
                        employeeDTO.setId (employees.getId ());
                        employeeDTO.setName (employees.getFname ()+" "+employees.getLname ());
                        employeeDTO.setAge (employeeDTO.getAge ());
                        employeeDTO.setSal (employees.getSal ());
                        employeeDTO.setDept (employees.getDept ());
                        return employeeDTO;
                    }
                }).collect (Collectors.toList ());

        final List<EmployeeDTO> collect1 = se.loadEmployeesFromDB ()
                .stream ()
                .map (e -> {
                                    EmployeeDTO employeeDTO = new EmployeeDTO ();
                                    employeeDTO.setId (e.getId ());
                                    employeeDTO.setName (e.getFname ()+" "+e.getLname ());
                                    employeeDTO.setAge (e.age);
                                    employeeDTO.setSal (e.getSal ());
                                    employeeDTO.setDept (e.getDept ());
                                    return employeeDTO;

                            }).collect (Collectors.toList ());


        se.loadEmployeesFromDB ().stream ()
                .reduce (new BinaryOperator<Employees> () {
                    @Override
                    public Employees apply(Employees employees, Employees employees2) {
                        return null;
                    }
                }).get ();

        //se.loadEmployeesFromDB ().stream ()

        //// instance method reference
        EmployeeMapper employeeMapper = new EmployeeMapper ();
        final List<EmployeeDTO> collect2 = se.loadEmployeesFromDB ()
                .stream ()
                .map (employeeMapper::convert).collect (Collectors.toList ()); // instance method reference




    }

    public static void print(Employees employees){
        System.out.println (employees);

    }

}
