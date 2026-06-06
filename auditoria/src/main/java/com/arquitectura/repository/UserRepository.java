package com.arquitectura.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arquitectura.models.UsersModel;

public interface UserRepository extends JpaRepository<UsersModel, UUID>{

}
