package com.somesh.sbmaven.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamObjectEx {

    public static void main(String[] args) {
        List<Employees> list = getEmployeeDetails();

        List<Employees> copy = new ArrayList<> (list);

        copy.sort ((o1,o2) -> o2.getSal () - o1.getSal ());

        for (int z=0;z<3;z++){
            System.out.println (copy.get (z).toString ());
        }


        // Sorted and top 3 records whose salary is highest
        list.stream ().sorted (Comparator.comparingInt (Employees::getSal).reversed ())
                .limit (3)
                .map(Employees::getFname)
                .forEach (System.out::println);

        List<String> empList  = list.stream()
                //.limit (3)
                .map(Employees::getFname)
                .toList ();

        Set<String> empSet  = list.stream()
                //.limit (3)
                .map(Employees::getFname)
                .collect (Collectors.toSet ());

        Set<Employees> empSet1  = new HashSet<> (list);
        empSet1.forEach (System.out::println);

        Map<Integer, Employees> empMap = list.stream ()
                //.sorted (Comparator.comparingInt (Employees::getSal).reversed ())
                .collect (Collectors.toMap(e -> e.getId (), e -> e));

        System.out.println ("========================");

        empMap.entrySet ().forEach (System.out::println);

        System.out.println ("======================== ");


        Map<Integer, Long> deptMap = list.stream ()
                //.sorted (Comparator.comparingInt (Employees::getDept))
                .collect (Collectors.groupingBy (Employees::getDept, Collectors.counting ()));

        deptMap.entrySet ().stream ().forEach (System.out::println);


        Map<Integer, List<Employees>> map  = list.stream ()
                .parallel ()
                .collect(Collectors.groupingBy (Employees::getDept));

        map.entrySet ().forEach (System.out::println);

    }

    public static List<Employees> getEmployeeDetails(){

        List<Employees> list = new ArrayList<> ();

        Employees employees1 = new Employees (1,"Somesh","kandula", "30", 1000,10);
        Employees employees2 = new Employees (2,"Ramesh","kandula", "31", 3000,20);
        Employees employees3 = new Employees (3,"Suresh","kandula", "32", 4000,10);
        Employees employees4 = new Employees (4,"Anklet","kandula", "33", 5000,10);
        Employees employees5 = new Employees (5,"Palito","kandula", "34", 2000,30);

        list.add (employees1);
        list.add (employees2);
        list.add (employees3);
        list.add (employees4);
        list.add (employees5);

        return list;
    }

    public List<Employees> loadEmployeesFromDB(){
        return IntStream.range (1, 10)
                .mapToObj (i -> new Employees (i, "fName"+i, "lName"+i, "2"+i,i+1000,10)).collect (Collectors.toList ());
    }

}

