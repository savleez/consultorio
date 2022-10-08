# consultorio

## Querys para creación de base de datos local MySQL

CREATE SCHEMA consultorio;
CREATE USER 'usuario'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON consultorio.* TO 'usuario'@'%';
