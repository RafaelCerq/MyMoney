CREATE TABLE categoria(
	codigo BIGINT(20) primary key AUTO_INCREMENT,
	nome VARCHAR(50) not null
)ENGINE=InnoDB DEFAULT charset=utf8;

INSERT INTO categoria (nome) VALUES ('Lazer');
INSERT INTO categoria (nome) VALUES ('Alimentação');
INSERT INTO categoria (nome) VALUES ('Supermercado');
INSERT INTO categoria (nome) VALUES ('Farmacia');
INSERT INTO categoria (nome) VALUES ('Outros');