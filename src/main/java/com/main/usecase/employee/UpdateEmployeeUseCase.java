package com.main.usecase.employee;

import com.main.dto.GeneralEmployeeInfoDTO;
import com.main.model.EmployeeModel;
import com.main.repository.IEmployeeRepository;
import com.main.usecase.utilities.GeneralUtilitiesUseCase;
import com.main.usecase.utilities.ValidationsUseCase;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class UpdateEmployeeUseCase {

    @Autowired
    IEmployeeRepository employeeRepository;
    @Autowired
    GeneralUtilitiesUseCase generalUtilitiesUseCase;
    @Autowired
    ValidationsUseCase validationsUseCase;

    public ResponseEntity<?> execute(GeneralEmployeeInfoDTO request) throws Exception {
        JSONObject response = new JSONObject();

        //Busqueda del registro de empleado por ID
        EmployeeModel employeeInfo = generalUtilitiesUseCase.findEmployee(request.getEmpleadoId());

        //Validacion de campos String
        validationsUseCase.requiredString(request.getNombre(), request.getPuesto(), request.getFechaContratacion());

        //Validacion de campos Decimal
        validationsUseCase.requiredBigDecimal(request.getSalario());

        //Obtencion de la fecha actual
        Date actualDate = generalUtilitiesUseCase.getActualDate();

        //Conversion de la fecha formato String a formato Date
        Date hireDate = generalUtilitiesUseCase.stringToDate(request.getFechaContratacion());

        //Asignacion de valores desde request a el modelo
        employeeInfo.setEmployeeName(request.getNombre());
        employeeInfo.setEmployeePosition(request.getPuesto());
        employeeInfo.setEmployeeSalary(request.getSalario());
        employeeInfo.setEmployeeHireDate(hireDate);
        employeeInfo.setUpdatedAt(actualDate);

        //Envio de modelo al repositorio para su almacenamiento en la base de datos.
        this.employeeRepository.save(employeeInfo);

        //Construccion de la respuesta exitosa
        response.put("status", "ok");
        response.put("message", "Datos actualizados de forma correcta");

        return ResponseEntity.ok(response.toMap());
    }

}
