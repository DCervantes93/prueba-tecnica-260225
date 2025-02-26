package com.main.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public class RegisterEmployeeDTO {

    @Getter
    @Setter
    private String nombre;

    @Getter
    @Setter
    private String puesto;

    @Getter
    @Setter
    private BigDecimal salario;

    @Getter
    @Setter
    private String fechaContratacion;

}
