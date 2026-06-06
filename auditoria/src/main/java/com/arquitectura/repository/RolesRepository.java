package com.arquitectura.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arquitectura.models.RolesModel;

public interface RolesRepository extends JpaRepository<RolesModel, UUID> {

}
