DROP
DATABASE IF exists dep_project;
create
database dep_project;
USE
dep_project;

-- Table: departments
CREATE TABLE departments
(
    id                      bigint       NOT NULL AUTO_INCREMENT,
    name                    varchar(255) NOT NULL,
    head_of_department_name varchar(255) NOT NULL,
    CONSTRAINT departments_pk PRIMARY KEY (id)
);

-- Table: lectors
CREATE TABLE lectors
(
    id         bigint      NOT NULL AUTO_INCREMENT,
    degree     ENUM('ASSISTANT', 'ASSOCIATE_PROFESSOR', 'PROFESSOR') NOT NULL,
    first_name varchar(60) NOT NULL,
    last_name  varchar(60) NOT NULL,
    birth_date date        NOT NULL,
    CONSTRAINT lectors_pk PRIMARY KEY (id)
);

-- Table: link_to_department
CREATE TABLE link_to_department
(
    departments_id bigint NOT NULL,
    lectors_id     bigint NOT NULL,
    salary         int    NOT NULL,
    CONSTRAINT link_to_department_pk PRIMARY KEY (departments_id, lectors_id)
);

-- foreign keys
-- Reference: link_to_department_departments  (table: link_to_department)
ALTER TABLE link_to_department
    ADD CONSTRAINT link_to_department_departments FOREIGN KEY link_to_department_departments (departments_id)
    REFERENCES departments (id);

-- Reference: link_to_department_lectors (table: link_to_department)
ALTER TABLE link_to_department
    ADD CONSTRAINT link_to_department_lectors FOREIGN KEY link_to_department_lectors (lectors_id)
    REFERENCES lectors (id);

-- End of file.

