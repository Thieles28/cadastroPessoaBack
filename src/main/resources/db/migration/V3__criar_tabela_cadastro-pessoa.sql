CREATE TABLE tb_cadastro
(
    codigo     bigint       PRIMARY KEY,
    cpf        varchar(11)  NOT NULL,
    data       date         NOT NULL,
    email      varchar(200) DEFAULT NULL,
    cod_pais   bigint       NOT NULL,
    cod_estado bigint       NOT NULL,
    nome       varchar(100) NOT NULL,
    sexo       char(1)      DEFAULT NULL,
    PRIMARY KEY (codigo),
    UNIQUE KEY tb_cadastro_cpf_uindex (cpf),
    KEY fk_pais (cod_pais),
    KEY fk_estado (cod_estado),
    CONSTRAINT fk_estado FOREIGN KEY (cod_estado) REFERENCES tb_estado (codigo),
    CONSTRAINT fk_pais FOREIGN KEY (cod_pais) REFERENCES tb_pais (codigo),
    CONSTRAINT ck_sexo CHECK ((sexo in (_utf8mb4'M', _utf8mb4'F')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tb_cadastro (cpf, `data`, email, cod_pais, cod_estado, nome, sexo)
VALUES ('02030145106', '1987-10-29', 'thieles@gmailcom', 33, 26, 'Thieles', 'M'),
       ('16481965004', '1981-10-23', 'ricardo@gmailcom', 33, 26, 'Ricardo', 'M'),
       ('46435225001', '1982-10-20', 'jessica@gmailcom', 33, 26, 'Jessica', 'F'),
       ('52906298077', '1983-10-27', 'joana@gmailcom', 33, 26, 'Joana', 'F'),
       ('91374959090', '1984-10-25', 'yasmin@gmailcom', 33, 26, 'Yasmin', 'F'),
       ('68044964002', '1985-10-24', 'carla@gmailcom', 33, 26, 'Carla', 'F'),
       ('95768330003', '1986-10-22', 'rebeca@gmailcom', 33, 26, 'Rebeca', 'F'),
       ('58913211068', '1990-10-28', 'thayla@gmailcom', 33, 26, 'Thayla', 'F'),
       ('73154267018', '1997-10-09', 'carlos@gmailcom', 33, 26, 'Carlos', 'M'),
       ('60019491077', '1998-10-01', 'lucio@gmailcom', 33, 26, 'Luciano', 'M'),
       ('00835876080', '1999-10-11', 'rodriog@gmailcom', 33, 26, 'Rodrigo', 'M'),
       ('96553799067', '1983-10-13', 'romilson@gmailcom', 33, 26, 'Romilson', 'M'),
       ('73390792031', '1985-10-20', 'rogerio@gmailcom', 33, 26, 'Rogério', 'M'),
       ('38088914086', '1987-10-19', 'everton@gmailcom', 33, 26, 'Everton', 'M');