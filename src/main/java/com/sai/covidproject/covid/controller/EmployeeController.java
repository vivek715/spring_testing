package com.sai.covidproject.covid.controller;

import com.sai.covidproject.covid.entity.Employee;
import com.sai.covidproject.covid.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("getAllEmployees/employees")

    public @ResponseBody
    ResponseEntity<List<Employee>> getAllEmployees() {

        List<Employee> employeeList = employeeService.getAllEmployees();
        return ResponseEntity.ok().body(employeeList);

    }
    //xml marshalling getting data from db and making them into xml files.




  /*  @GetMapping("getEmployeeById/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Employee employee = employeeService.getEmployeeById(employeeId);
              //  .orElseThrow(() -> new ResourceNotFoundException());
        return ResponseEntity.ok().body(employee);
    }*/

   /* @PostMapping("createEmployee/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }*/

    /*@PutMapping("updateEmployee/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                   @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException());

        employee.setClassname(employeeDetails.getClassname());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("deleteEmployee/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException());

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }*/
}