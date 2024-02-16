DROP TABLE IF EXISTS courses;

CREATE TABLE courses
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(255) NOT NULL,
    body TEXT
);

DROP TABLE IF EXISTS cars;

CREATE TABLE users
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

