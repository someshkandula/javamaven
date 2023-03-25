package com.somesh.sbmaven.streams;

public class EmployeeMapper {

    public EmployeeDTO convert(Employees employees){

        EmployeeDTO employeeDTO = new EmployeeDTO ();
        employeeDTO.setId (employees.getId ());
        employeeDTO.setName (employees.getFname ()+" "+employees.getLname ());
        employeeDTO.setAge (employeeDTO.getAge ());
        employeeDTO.setSal (employees.getSal ());
        employeeDTO.setDept (employees.getDept ());
        return employeeDTO;
    }
}
