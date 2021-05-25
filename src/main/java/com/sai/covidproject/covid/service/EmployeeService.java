package com.sai.covidproject.covid.service;

import com.sai.covidproject.covid.entity.Employee;
import com.sai.covidproject.covid.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

     @Autowired
    EmployeeRepository employeeRepository;


    public List<Employee> getAllEmployees() {

        List<Employee> employeeList = new ArrayList<>();

         employeeRepository.findAll().forEach(emp->{employeeList.add(emp);
             System.out.println(emp);
         });
         return employeeList;

    }

 /*   public Employee getEmployeeById(Long employeeId) {
        return  employeeRepository.findById(employeeId).get();  // optional
    }*/

    /*public Employee createEmployee(Employee employee) {
         employeeRepository.save(employee);
         return employee;

    }*/
}
