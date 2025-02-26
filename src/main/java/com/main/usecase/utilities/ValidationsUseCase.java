package com.main.usecase.utilities;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class ValidationsUseCase {


    public void requiredString(String... fieldsToValidate) throws Exception {
        //Se recorre la lista de valores enviados, si encuentra uno vacio o nulo, lanza la excepción
        for (String field : fieldsToValidate) {
            if (field == null || field.isEmpty()) {
                throw new Exception("Uno o más campos STRING se encuentran vacíos o son invalidos");
            }
        }
    }

    public void requiredBigDecimal(BigDecimal... fieldsToValidate) throws Exception {
        //Se recorre la lista de valores enviados, si encuentra uno nulo o menor a uno, lanza la excepción
        for (BigDecimal field : fieldsToValidate) {
            if (field == null || field.compareTo(BigDecimal.ZERO) < 1) {
                throw new Exception("Uno o más campos DECIMAL se encuentran vacíos o son invalidos");
            }
        }
    }


}
