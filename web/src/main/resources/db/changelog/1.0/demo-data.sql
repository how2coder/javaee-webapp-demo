-- liquibase formatted sql

-- changeset j2eedemo_user:1
-- comment department demo data
INSERT INTO j2eedemo.department (id, name)
VALUES (1, 'Accounting facility'),
       (2, 'Marketing / Sales'),
       (3, 'Finance / Admin'),
       (4, 'Operations'),
       (5, 'HR'),
       (6, 'Client Support'),
       (7, 'IT-Support / IT-Security'),
       (8, 'Research & Development'),
       (9, 'Quality assurance');

-- changeset j2eedemo_user:2
-- comment employee demo data
INSERT INTO j2eedemo.employee (id, active, first_name, last_name, birth_date, salary, department_id)
VALUES (1, 1, 'Christy', 'Holmes', '1980-04-07', 25000.00, 1),
       (2, 1, 'Douglas', 'Schmidt', '1990-05-07', 11000.00, 1),
       (3, 0, 'Elizabeth', 'Garza', '1993-02-03', 17000.00, 1),
       (4, 1, 'Theresa', 'Cunningham', '1983-12-17', 12500.00, 1),

       (5, 1, 'Christian', 'Watson', '1984-07-08', 23000.00, 2),
       (6, 1, 'Alma', 'Torres', '1987-08-09', 15000.00, 2),
       (7, 1, 'Erin', 'Vasquez', '1988-09-22', 15300.00, 2),
       (8, 1, 'Jose', 'Barnett', '1992-06-23', 7000.00, 2),

       (9, 1, 'Frances', 'Andrews', '1978-03-27', 31000.00, 3),
       (10, 1, 'Michael', 'Fox', '1988-09-20', 25000.00, 3),
       (11, 1, 'Randy', 'Wilson', '1992-04-07', 14500.00, 3),
       (12, 1, 'Alan', 'Ellis', '1987-08-04', 17200.00, 3),

       (13, 1, 'Nicholas', 'Garcia', '1985-01-01', 29000.00, 4),
       (14, 1, 'Brandie', 'Mckinney', '1986-11-14', 21000.00, 4),
       (15, 1, 'Dale', 'Terry', '1987-09-21', 19350.00, 4),
       (16, 1, 'Kathy', 'Webb', '1988-02-14', 12500.00, 4),
       (17, 1, 'Charles', 'Hopkins', '1988-03-26', 13400.00, 4),

       (18, 1, 'Calvin', 'Carlson', '1985-04-09', 35050.00, 5),
       (19, 1, 'Juanita', 'Henry', '1980-03-18', 12000.00, 5),
       (20, 0, 'Harvey', 'Pena', '1989-10-15', 17950.00, 5),
       (21, 1, 'Marshall', 'Butler', '1991-11-14', 7900.00, 5),
       (22, 1, 'Tom', 'Wallace', '1982-10-19', 16200.00, 5),
       (23, 1, 'Maxine', 'Davis', '1995-11-23', 14900.00, 5),

       (24, 1, 'Derrick', 'Hale', '1998-12-27', 29000.00, 6),
       (25, 1, 'Morris', 'Lucas', '1995-11-12', 25200.00, 6),
       (26, 1, 'Allison', 'Rodriquez', '1993-04-07', 21750.00, 6),
       (27, 0, 'Marc', 'Moore', '1995-03-07', 13800.00, 6),
       (28, 0, 'Frederick', 'Rodriquez', '1992-06-13', 17100.00, 6),
       (29, 1, 'Diane', 'Terry', '1988-09-12', 15600.00, 6),
       (30, 1, 'Miriam', 'Armstrong', '1987-03-21', 19250.00, 6),

       (31, 1, 'Deann', 'Franklin', '1983-11-11', 33000.00, 7),
       (32, 1, 'Juanita', 'Brown', '1985-08-13', 21200.00, 7),
       (33, 1, 'Daniel', 'Vargas', '1987-02-19', 11400.00, 7),
       (34, 0, 'Dan', 'Franklin', '1994-01-28', 16100.00, 7),
       (35, 1, 'Wilma', 'Elliott', '1992-05-26', 12300.00, 7),
       (36, 1, 'Marjorie', 'Garrett', '1989-06-12', 7800.00, 7),

       (37, 1, 'Allen', 'Welch', '1983-03-11', 40400.00, 8),
       (38, 1, 'Arnold', 'Holt', '1980-08-23', 23300.00, 8),
       (39, 1, 'Avery', 'Morgan', '1986-06-22', 16700.00, 8),
       (40, 1, 'Ronald', 'Martin', '1988-07-20', 13400.00, 8),
       (41, 0, 'Steven', 'Campbell', '1997-05-19', 12900.00, 8),
       (42, 1, 'Patrick', 'Bryant', '1998-03-08', 12300.00, 8),

       (43, 1, 'Leslie', 'Morgan', '1988-02-12', 26200.00, 9),
       (44, 1, 'Same', 'Dean', '1992-06-15', 21200.00, 9),
       (45, 0, 'Charlie', 'James', '1987-04-18', 16300.00, 9),
       (46, 1, 'Valerie', 'Wallace', '1983-04-13', 17840.00, 9),
       (47, 1, 'Constance', 'Steward', '1987-04-29', 11111.00, 9),
       (48, 0, 'Leslie', 'Gilbert', '1980-08-23', 12340.00, 9),
       (49, 1, 'Luis', 'Fleming', '1992-09-28', 18000.00, 9);

-- changeset j2eedemo_user:3
-- comment manager demo data
INSERT INTO j2eedemo.manager (id, department_id, employee_id)
VALUES (1, 1, 1),
       (2, 2, 5),
       (3, 3, 9),
       (4, 4, 13),
       (5, 5, 18),
       (6, 6, 24),
       (7, 7, 31),
       (8, 8, 37),
       (9, 9, 43);

