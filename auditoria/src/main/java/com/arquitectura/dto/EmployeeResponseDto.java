package com.arquitectura.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeResponseDto {
    private UUID id;
    private String legajo;
    private String nombre;
    private String apellido;
    private String email;
    private String puesto;
    private BigDecimal sueldo;
    private DepartmentResponseDto department;
    private UserResponseDto user;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
