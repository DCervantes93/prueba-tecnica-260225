package com.main.usecase.utilities;

import com.main.model.EmployeeModel;
import com.main.repository.IEmployeeRepository;
import com.main.utils.HttpErrorJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Service
public class GeneralUtilitiesUseCase {

    @Autowired
    IEmployeeRepository employeeRepository;

    public Date stringToDate(String request) throws Exception {
        //Definicion del formato de fecha
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Concatenacion de hora 0 al string para cumplir con el formato
        String dateHourString =  request + " 00:00:00";

        // Parseo y retorno de fecha con el formato definido
        return formatter.parse(dateHourString);
    }

    public Date getActualDate(){
        //Definicion de la zona horaria
        ZoneId mainZone = ZoneId.of("America/Mexico_City");

        //Obtencion de la fecha y hora actual en la zona horaria
        ZonedDateTime zonedDateTime = ZonedDateTime.now(mainZone);

        //Conversion y retorno de la fecha y hora
        return Date.from(zonedDateTime.toInstant());
    }

    public EmployeeModel findEmployee(Long registerId) {
        return employeeRepository.findById(registerId)
                .orElseThrow(() -> new HttpErrorJson(HttpStatus.BAD_REQUEST, "No se ha encontrado el empleado con el ID ingresado"));
    }

}
