package com.arquitectura.repository;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arquitectura.models.EmployeesModel;


public interface  EmployeeRepository extends JpaRepository<EmployeesModel,UUID >{

}
