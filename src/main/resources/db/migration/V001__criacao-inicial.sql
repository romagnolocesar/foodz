create table cozinha(
	id bigint not null auto_increment,
	nome VARCHAR(60) not null,
	descricao VARCHAR(255),
	
	PRIMARY key(id)
)ENGINE=INNODB default charset=utf8;
