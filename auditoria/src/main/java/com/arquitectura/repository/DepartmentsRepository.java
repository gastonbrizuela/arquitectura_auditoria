package com.arquitectura.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arquitectura.models.DepartmentsModel;

public interface DepartmentsRepository extends JpaRepository<DepartmentsModel, UUID> {

}
