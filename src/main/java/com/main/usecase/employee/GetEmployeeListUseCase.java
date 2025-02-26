package com.main.usecase.employee;

import com.main.dto.GeneralEmployeeInfoDTO;
import com.main.model.EmployeeModel;
import com.main.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetEmployeeListUseCase {

    @Autowired
    IEmployeeRepository employeeRepository;

    public List<GeneralEmployeeInfoDTO> execute(){
        List<GeneralEmployeeInfoDTO> response = new ArrayList<>();

        //Obtencion de todos los registros en la tabla "empleados"
        List<EmployeeModel> getAllRegisters = this.employeeRepository.findAll();

        for(EmployeeModel element : getAllRegisters) {

            GeneralEmployeeInfoDTO buildDTO = new GeneralEmployeeInfoDTO();

            //Asignacion de los valores del elemento al DTO
            buildDTO.setEmpleadoId(element.getEmployeeId());
            buildDTO.setNombre(element.getEmployeeName());
            buildDTO.setPuesto(element.getEmployeePosition());
            buildDTO.setSalario(element.getEmployeeSalary());

            //Asignacion y validacion de fecha, si es diferente de nulo, retorna la fecha sin hora, caso contrario, retorna nulo
            buildDTO.setFechaContratacion(
                    element.getEmployeeHireDate() != null ? element.getEmployeeHireDate().toString().split(" ")[0] : null
            );

            //Adicion a la lista final
            response.add(buildDTO);
        }


        return response;
    }

}
