USE
dep_project;

insert INTO departments(name, head_of_department_name)
values ('IT', 'Ted Silkston'),
       ('Management', 'Yuma Blaszkiewicz'),
       ('Marketing', 'Yance Conn'),
       ('Finance', 'Carmelia Wippermann'),
       ('Sales', 'Wiatt Arsnell');

insert into lectors(degree, first_name, last_name, birth_date)
values ('PROFESSOR', 'Lindy', 'Elener', '1980-01-01'),
       ('ASSISTANT', 'Kalila', 'McCourt', '1981-02-02'),
       ('ASSOCIATE_PROFESSOR', 'Fletch', 'Willgress', '1983-03-03'),
       ('ASSISTANT', 'Tamma', 'Nancekivell', '1984-04-04'),
       ('ASSOCIATE_PROFESSOR', 'Hadleigh', 'Hanscombe', '1985-05-05'),
       ('ASSISTANT', 'Brigitta', 'Osbidston', '1986-06-06'),
       ('PROFESSOR', 'Hilliard', 'Lead', '1987-07-07'),
       ('ASSOCIATE_PROFESSOR', 'Simonette', 'Harpin', '1988-08-08'),
       ('ASSISTANT', 'Emanuele', 'Nanuccioi', '1989-09-09'),
       ('ASSOCIATE_PROFESSOR', 'Devonne', 'Rowan', '1990-10-10'),
       ('ASSISTANT', 'Adolph', 'Karpushkin', '1991-11-11'),
       ('PROFESSOR', 'Winnah', 'Stears', '1992-12-12');

insert into link_to_department(departments_id, lectors_id, salary)
values (1, 1, 12000),
       (1, 2, 7000),
       (1, 3, 9530),
       (1, 4, 7000),
       (1, 5, 9530),
       (1, 6, 7000),
       (1, 7, 12000),
       (1, 8, 9530),
       (1, 9, 7000),
       (1, 10, 9530),
       (1, 11, 10090),
       (1, 12, 12000);

insert into link_to_department(departments_id, lectors_id, salary)
values (2, 1, 12000),
       (2, 2, 7000),
       (2, 3, 9530),
       (2, 4, 7000),
       (2, 5, 9530),
       (2, 6, 7000),
       (2, 7, 12000),
       (2, 8, 9530);

insert into link_to_department(departments_id, lectors_id, salary)
values (3, 7, 12000),
       (3, 8, 9530),
       (3, 9, 7000),
       (3, 10, 9530),
       (3, 11, 10090),
       (3, 12, 12000);

insert into link_to_department(departments_id, lectors_id, salary)
values (4, 4, 7000),
       (4, 5, 9530),
       (4, 6, 7000),
       (4, 7, 12000),
       (4, 8, 9530),
       (4, 11, 10090),
       (4, 12, 12000);

insert into link_to_department(departments_id, lectors_id, salary)
values (5, 1, 16020),
       (5, 2, 7405),
       (5, 3, 9530);