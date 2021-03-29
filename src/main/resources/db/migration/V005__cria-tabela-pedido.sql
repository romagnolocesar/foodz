create table item_pedido (
id bigint not null auto_increment, 
observacao varchar(255), 
preco_total decimal(19,2) not null, 
preco_unitario decimal(19,2) not null, 
quantidade integer not null, 
pedido_id bigint, 
produto bigint not null, 

primary key (id)
) engine=InnoDB charset=utf8;


create table pedido (
	id bigint not null auto_increment, 
	data_cancelamento datetime, 
	data_confirmacao datetime, 
	data_criacao datetime not null, 
	data_entrega datetime, 
	endereco_bairro varchar(255), 
	endereco_cep varchar(9), 
	endereco_complemento varchar(255), 
	endereco_logradouro varchar(255), 
	endereco_numero varchar(255), 
	status integer not null, 
	sub_total decimal(19,2), 
	taxa_frete decimal(19,2) not null, 
	valor_total decimal(19,2) not null, 
	cliente_id bigint not null, 
	endereco_cidade_id bigint, 
	forma_pagamento_id bigint not null, 
	restaurante_id bigint not null, 
	
	primary key (id)
	) engine=InnoDB charset=utf8;


alter table item_pedido add constraint item_pedido_pedido foreign key (pedido_id) references pedido (id);
alter table item_pedido add constraint item_pedido_produto foreign key (produto) references produto (id);
alter table pedido add constraint pedido_cliente foreign key (cliente_id) references usuario (id);
alter table pedido add constraint pedido_endereco_cidade foreign key (endereco_cidade_id) references cidade (id);
alter table pedido add constraint pedido_forma_pagamento foreign key (forma_pagamento_id) references forma_pagamento (id);
alter table pedido add constraint pedido_restaurante foreign key (restaurante_id) references restaurante (id);