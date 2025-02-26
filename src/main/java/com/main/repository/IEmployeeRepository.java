package com.main.repository;

import com.main.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<EmployeeModel, Long> {
}
