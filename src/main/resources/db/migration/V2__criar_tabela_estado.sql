CREATE TABLE tb_estado
(
    codigo serial    PRIMARY KEY,
    nome   varchar(100) NOT NULL,
    PRIMARY KEY (codigo)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO
    tb_estado(nome)
    VALUES
       ('Rondônia'),
       ('Acre'),
       ('Amazonas'),
       ('Roraima'),
       ('Pará'),
       ('Amapá'),
       ('Tocantins'),
       ('Maranhão'),
       ('Piauí'),
       ('Ceará'),
       ('Rio Grande do Norte'),
       ('Paraíba'),
       ('Pernambuco'),
       ('Alagoas'),
       ('Sergipe'),
       ('Minas Gerais'),
       ('Espírito Santo'),
       ('Rio de Janeiro'),
       ('São Paulo'),
       ('Paraná'),
       ('Santa Catarina'),
       ('Rio Grande do Sul'),
       ('Mato Grosso do Sul'),
       ('Mato Grosso'),
       ('Goiás'),
       ('Distrito Federal');