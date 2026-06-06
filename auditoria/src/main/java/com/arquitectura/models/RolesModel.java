package com.arquitectura.models;

import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RolesModel extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable=false)
    private UUID id;

    @Column(name= "name", nullable=false)
    private String name;


    // Lado inverso de la relación: no gestiona la tabla intermedia.
    // "mappedBy" le dice a JPA que quien manda es el campo "roles" de UsersModel.
    @ManyToMany(mappedBy = "roles")
    private Set<UsersModel> users;
}
