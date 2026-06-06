-- V1__create_initial_tables.sql

CREATE TABLE departments (
    id              UUID            NOT NULL,
    name            VARCHAR(255)    NOT NULL,
    created_date    TIMESTAMP,
    last_modified_date  TIMESTAMP,
    created_by      VARCHAR(255),
    last_modified_by    VARCHAR(255),
    CONSTRAINT pk_departments PRIMARY KEY (id)
);

CREATE TABLE roles (
    id              UUID            NOT NULL,
    name            VARCHAR(255)    NOT NULL,
    created_date    TIMESTAMP,
    last_modified_date  TIMESTAMP,
    created_by      VARCHAR(255),
    last_modified_by    VARCHAR(255),
    CONSTRAINT pk_roles PRIMARY KEY (id)
);

CREATE TABLE users (
    id          UUID            NOT NULL,
    username    VARCHAR(255)    NOT NULL,
    password    VARCHAR(255)    NOT NULL,
    name        VARCHAR(255)    NOT NULL,
    CONSTRAINT pk_users         PRIMARY KEY (id),
    CONSTRAINT uq_users_username UNIQUE (username)
);

CREATE TABLE employees (
    id                  UUID            NOT NULL,
    legajo              VARCHAR(255),
    nombre              VARCHAR(255),
    apellido            VARCHAR(255),
    email               VARCHAR(255),
    puesto              VARCHAR(255),
    sueldo              DECIMAL(19, 2),
    department_id       UUID            NOT NULL,
    user_id             UUID,
    created_date        TIMESTAMP,
    last_modified_date  TIMESTAMP,
    created_by          VARCHAR(255),
    last_modified_by    VARCHAR(255),
    CONSTRAINT pk_employees         PRIMARY KEY (id),
    CONSTRAINT uq_employees_legajo  UNIQUE (legajo),
    CONSTRAINT uq_employees_email   UNIQUE (email),
    CONSTRAINT uq_employees_user_id UNIQUE (user_id),
    CONSTRAINT fk_employees_department  FOREIGN KEY (department_id) REFERENCES departments (id),
    CONSTRAINT fk_employees_user        FOREIGN KEY (user_id)        REFERENCES users (id)
);

CREATE TABLE users_roles (
    user_id UUID NOT NULL,
    role_id UUID NOT NULL,
    CONSTRAINT pk_users_roles PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_users_roles_user FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_users_roles_role FOREIGN KEY (role_id) REFERENCES roles (id)
);
