package com.arquitectura.models;

import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersModel {
    // id, username, password, name, created_at, updated_at
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    // Lado dueño de la relación: esta entidad es responsable de crear/gestionar
    // la tabla intermedia "users_roles" en la base de datos.
    // FetchType.EAGER carga los roles junto con el usuario en la misma consulta.
    // Lado inverso: no tiene FK en su tabla, solo referencia al lado dueño (EmployeesModel).
    @OneToOne(mappedBy = "user")
    private EmployeesModel employee;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "users_roles",                               // nombre de la tabla intermedia generada por JPA
        joinColumns = @JoinColumn(name = "user_id"),        // FK que apunta a esta tabla (UsersModel)
        inverseJoinColumns = @JoinColumn(name = "role_id")  // FK que apunta a la otra tabla (RolesModel)
    )
    private Set<RolesModel> roles;
}
