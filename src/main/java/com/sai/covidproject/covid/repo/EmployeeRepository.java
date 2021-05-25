package com.sai.covidproject.covid.repo;

import com.sai.covidproject.covid.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {




}
