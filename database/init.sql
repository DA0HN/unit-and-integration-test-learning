CREATE TABLE student
(
    id     serial,
    name   varchar(50),
    email  varchar(50),
    gender varchar(20),
    primary key (id)
);

INSERT INTO student (name, email, gender)
VALUES ('Laura', 'TakeAway@inbox.company', 'FEMALE');
INSERT INTO student (name, email, gender)
VALUES ('Zachary', 'Prometheus@inbox.cz', 'MALE');
INSERT INTO student (name, email, gender)
VALUES ('Tara', 'K9@aim.us', 'OTHER');
INSERT INTO student (name, email, gender)
VALUES ('Nicole', 'Cujo@gmx.bio', 'FEMALE');
INSERT INTO student (name, email, gender)
VALUES ('Steven', 'MrSpy@gmail.ru', 'MALE');
INSERT INTO student (name, email, gender)
VALUES ('Bobby', 'DesertHaze@inbox.cl', 'MALE');
INSERT INTO student (name, email, gender)
VALUES ('Ike', 'TakeAway@inbox.company', 'OTHER');
