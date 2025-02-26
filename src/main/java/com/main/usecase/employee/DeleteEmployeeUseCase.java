package com.main.usecase.employee;

import com.main.repository.IEmployeeRepository;
import com.main.usecase.utilities.GeneralUtilitiesUseCase;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteEmployeeUseCase {

    @Autowired
    IEmployeeRepository employeeRepository;
    @Autowired
    GeneralUtilitiesUseCase generalUtilitiesUseCase;

    public ResponseEntity<?> execute(Long idEmployee){
        JSONObject response = new JSONObject();

        //Busqueda del registro de empleado por ID
        generalUtilitiesUseCase.findEmployee(idEmployee);

        //Eliminacion del registro desde el repositorio
        this.employeeRepository.deleteById(idEmployee);

        //Construccion de la respuesta exitosa
        response.put("status", "ok");
        response.put("message", "Datos eliminados de forma correcta");

        return ResponseEntity.ok(response.toMap());
    }

}
