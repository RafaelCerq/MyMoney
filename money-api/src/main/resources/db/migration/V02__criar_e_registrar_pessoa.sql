CREATE TABLE pessoa(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	logradouro VARCHAR(50),
	numero VARCHAR(10),
	complemento VARCHAR(20),
	bairro VARCHAR(20),
	cep VARCHAR(11),
	cidade VARCHAR(20),
	estado VARCHAR(2),
	ativo BOOLEAN
)ENGINE=InnoDB DEFAULT charset=utf8;

INSERT INTO pessoa (nome,logradouro,numero,complemento,bairro,cep,cidade,estado,ativo) VALUES ('Cristiano Silva','Rua das aves','556', null,'Santana','33.212-120','Belo Horizonte','MG',1);
INSERT INTO pessoa (nome,logradouro,numero,complemento,bairro,cep,cidade,estado,ativo) VALUES ('Rafael Cerqueira','Rua Nove de Julho','557', null,'Centro','19.883-120','Assis','SP',1);
INSERT INTO pessoa (nome,logradouro,numero,complemento,bairro,cep,cidade,estado,ativo) VALUES ('Crispim','Rua São Paulo','1257', null,'Lagoa Azul','12.165-450','Campinas','SP',1);
INSERT INTO pessoa (nome,logradouro,numero,complemento,bairro,cep,cidade,estado,ativo) VALUES ('Maria Oliveira','Rua Andrade','87','Correspondencia','Jardim Paraná','41.698-704','Mogi','SP',1);
INSERT INTO pessoa (nome,logradouro,numero,complemento,bairro,cep,cidade,estado,ativo) VALUES ('Ronaldo','Rua Angelo Bertoluci','769', null,'Morumbi','85.698-605','São Paulo','SP',1);