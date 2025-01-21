CREATE TABLE usuarios (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          nombre VARCHAR(255) NOT NULL,
                          correo_electronico VARCHAR(255) NOT NULL UNIQUE,
                          contrasenia VARCHAR(300) NOT NULL
);

CREATE TABLE cursos (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        nombre VARCHAR(255) NOT NULL
);

CREATE TABLE topicos (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         titulo VARCHAR(255) NOT NULL,
                         mensaje TEXT NOT NULL,
                         fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         autor_id BIGINT NOT NULL,
                         curso_id BIGINT NOT NULL,
                        estado tinyint(1) NOT NULL,
                         FOREIGN KEY (autor_id) REFERENCES usuarios(id) ON DELETE CASCADE,
                         FOREIGN KEY (curso_id) REFERENCES cursos(id) ON DELETE CASCADE
);
