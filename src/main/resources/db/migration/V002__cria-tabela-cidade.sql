create table cidade(
	id bigint not null auto_increment,
	nome_cidade varchar(80) not null,
	nome_estado varchar(80) not null,
	
	PRIMARY key(id)
)engine=InnoDB default charset=utf8;

INSERT INTO `cidade`(`id`, `nome_cidade`, `nome_estado`) VALUES (1, 'Uberlândia', 'Minas Gerais');
INSERT INTO `cidade`(`id`, `nome_cidade`, `nome_estado`) VALUES (2, 'Belo Horizonte', 'Minas Gerais');
INSERT INTO `cidade`(`id`, `nome_cidade`, `nome_estado`) VALUES (3, 'São Paulo', 'São Paulo');
INSERT INTO `cidade`(`id`, `nome_cidade`, `nome_estado`) VALUES (4, 'Recife', 'Pernambuco');
INSERT INTO `cidade`(`id`, `nome_cidade`, `nome_estado`) VALUES (5, 'Amazonas', 'Amazonas');
INSERT INTO `cidade`(`id`, `nome_cidade`, `nome_estado`) VALUES (6, 'Salvador', 'Bahia');
