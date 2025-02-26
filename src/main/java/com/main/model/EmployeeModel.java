package com.main.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "empleados")
public class EmployeeModel {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Long employeeId;


    @Getter
    @Setter
    @Column(name = "nombre")
    private String employeeName;

    @Getter
    @Setter
    @Column(name = "puesto")
    private String employeePosition;

    @Getter
    @Setter
    @Column(name = "salario")
    private BigDecimal employeeSalary;

    @Getter
    @Setter
    @Column(name = "fecha_contratacion")
    private Date employeeHireDate;

    @Getter
    @Setter
    @Column(name = "fecha_creacion")
    private Date createdAt;

    @Getter
    @Setter
    @Column(name = "fecha_edicion")
    private Date updatedAt;

}
