package com.main.controllers;

import com.main.dto.GeneralEmployeeInfoDTO;
import com.main.dto.RegisterEmployeeDTO;
import com.main.usecase.employee.DeleteEmployeeUseCase;
import com.main.usecase.employee.GetEmployeeListUseCase;
import com.main.usecase.employee.RegisterEmployeeUseCase;
import com.main.usecase.employee.UpdateEmployeeUseCase;
import com.main.utils.HttpErrorJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    RegisterEmployeeUseCase registerEmployeeUseCase;
    @Autowired
    GetEmployeeListUseCase getEmployeeListUseCase;
    @Autowired
    UpdateEmployeeUseCase updateEmployeeUseCase;
    @Autowired
    DeleteEmployeeUseCase deleteEmployeeUseCase;


    @PostMapping("/register-employee")
    public ResponseEntity<?> registerEmployee(@RequestBody RegisterEmployeeDTO request) {
        try {
            return registerEmployeeUseCase.execute(request);
        } catch (Exception e) {
            throw new HttpErrorJson(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/list-employees")
    public List<GeneralEmployeeInfoDTO> getListEmployees() {
        try {
            return getEmployeeListUseCase.execute();
        } catch (Exception e) {
            throw new HttpErrorJson(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/update-employee")
    public ResponseEntity<?> updateEmployee(@RequestBody GeneralEmployeeInfoDTO request) {
        try {
            return updateEmployeeUseCase.execute(request);
        } catch (Exception e) {
            throw new HttpErrorJson(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/delete-employee/{idEmployee}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("idEmployee") Long idEmployee) {
        try {
            return deleteEmployeeUseCase.execute(idEmployee);
        } catch (Exception e) {
            throw new HttpErrorJson(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
