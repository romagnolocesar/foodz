-- LIMPANDO AS TABELAS --
set foreign_key_checks = 0;
delete from cozinha;
delete from estado;
delete from cidade;
delete from restaurante;
delete from forma_pagamento;
delete from permissao;
delete from restaurante_forma_pagamento;
delete from produto;
delete from pedido;
delete from item_pedido;
set foreign_key_checks = 1;

-- ZERANDO ID AUTOINCREMENT --
alter table cozinha auto_increment = 1;
alter table estado auto_increment = 1;
alter table cidade auto_increment = 1;
alter table restaurante auto_increment = 1;
alter table forma_pagamento auto_increment = 1;
alter table grupo auto_increment = 1;
alter table permissao auto_increment = 1;
alter table produto auto_increment = 1;
alter table usuario auto_increment = 1;
alter table pedido auto_increment = 1;
alter table item_pedido auto_increment = 1;


-- COZINHAS ---
insert into cozinha (nome) values ('Tailandesa');
insert into cozinha (nome) values ('Indiana');
insert into cozinha (nome) values ('Japonesa');
insert into cozinha (nome) values ('Brasileira');

-- ESTADOS ---
insert into estado (nome) values ('São Paulo');
insert into estado (nome) values ('Paraná');
insert into estado (nome) values ('Mato Grosso');
insert into estado (nome) values ('Minas Gerais');

-- CIDADES ---
insert into cidade (nome, estado_id) values ('Jaú', 1);
insert into cidade (nome, estado_id) values ('Jandaia do Sul', 2);
insert into cidade (nome, estado_id) values ('Amambaí', 3);
insert into cidade (nome, estado_id) values ('Belo Horizonte', 4);

-- RESTAURANTES ---
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Centro', '38400999', NULL, 'Rua João Pinheiro', '1000', 'César`s Bistro', 5.00, 1, 1);
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Augusto Sanni', '38500190', NULL, 'Rua Albertina Bueno Campana', '10', 'Cantinho Brasileiro', 3.00, 2, 2);
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Fundão', '192168001', NULL, 'Rua Timelo Rego', '2500', 'Don Reny', 2.00, 3, 3);
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Centro', '12344122', NULL, 'Rua da Sequencia', '1234', 'Los Molinos', 1.00, 4, 4);
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Sul Profundo', '17666666', NULL, 'Rua Perdição Eterna', '666', 'Marmitaria Zé', 0.00, 4, 1);
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Norte Profundo', '99666996', NULL, 'Rua Contrariante', '999', 'Novilha de Ouro', 0.00, 2, 2);
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Centro', '38400999', NULL, 'Rua João Pinheiro', '1000', 'Iris`s Bistro', 5.00, 1, 1);
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Augusto Sanni', '38500190', NULL, 'Rua Albertina Bueno Campana', '10', 'Cantinho do João', 3.00, 2, 2);
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Fundão', '192168001', NULL, 'Rua Timelo Rego', '2500', 'Don Paulo', 2.00, 3, 3);
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Centro', '12344122', NULL, 'Rua da Sequencia', '1234', 'Los Tres', 1.00, 4, 4);
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Sul Profundo', '17666666', NULL, 'Rua Perdição Eterna', '666', 'Marmitaria Maria', 0.00, 4, 1);
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Norte Profundo', '99666996', NULL, 'Rua Contrariante', '999', 'Novilha Besta', 0.00, 2, 2);


-- FORMAS DE PAGAMENTOS ---
insert into forma_pagamento(descricao) values ('Dinheiro');
insert into forma_pagamento(descricao) values ('Cartão Crédito');
insert into forma_pagamento(descricao) values ('Débito');
insert into forma_pagamento(descricao) values ('Vale Alimentação');
insert into forma_pagamento(descricao) values ('Vale Refeição');
insert into forma_pagamento(descricao) values ('Voucher');

-- PERMISSOES DE USUARIOS ---
insert into permissao(nome, descricao) values ('Cadastrar Novos Usuários', 'Cadastrar novos usuarios no sistema.');
insert into permissao(nome, descricao) values ('Cadastrar Novas Cozinhas', 'Cadastrar novas cozinhas no sistema.');
insert into permissao(nome, descricao) values ('Alterar Permissoes', 'Alterar as permissoes dos usuarios');

-- RESTAURANTE FORMA PAGAMENTO --
insert ignore into restaurante_forma_pagamento(restaurante_id, forma_pagamento_id) VALUES (1, 1), (1,2), (1,3), (2,3), (3,2), (3,3);

-- PRODUTOS --
insert into produto(ativo, descricao, nome, preco, restaurante_id) VALUES (1, '10 Sushi+ 10 Hosomaki+ 5 Temaki+ 6 Hotroll', 'Combo Casal', 80, 4);
insert into produto(ativo, descricao, nome, preco, restaurante_id) VALUES (1, 'Pizza de quatro queijos de (Mussarela, Parmessao, Provolone, Catupiry)', 'Pizza Queijo', 40.5, 1);
insert into produto(ativo, descricao, nome, preco, restaurante_id) VALUES (1, 'Pizza Portuguesa de (Ervilha, Presunto, Queijo, Catupiry)', 'Pizza Portuguesa', 32.5, 1);
insert into produto(ativo, descricao, nome, preco, restaurante_id) VALUES (1, 'Macarrão Bolongnesa com molho de tomate caseiro', 'Macarrão Bolongnesa', 12.32, 2);
insert into produto(ativo, descricao, nome, preco, restaurante_id) VALUES (1, 'Hamburguer Gourmet com Molho especial', 'Hamburguer Baron II', 20, 2);
insert into produto(ativo, descricao, nome, preco, restaurante_id) VALUES (1, 'Hamburguer Gourmet de picanha com queijo emental ', 'Hamburguer Baron III', 20, 3);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Porco com molho agridoce', 'Deliciosa carne suína ao molho especial', 78.90, 1, 1);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Camarão tailandês', '16 camarões grandes ao molho picante', 110, 1, 1);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Salada picante com carne grelhada', 'Salada de folhas com cortes finos de carne bovina grelhada e nosso molho especial de pimenta vermelha', 87.20, 1, 2);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Garlic Naan', 'Pão tradicional indiano com cobertura de alho', 21, 1, 3);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Murg Curry', 'Cubos de frango preparados com molho curry e especiarias', 43, 1, 3);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Bife Ancho', 'Corte macio e suculento, com dois dedos de espessura, retirado da parte dianteira do contrafilé', 79, 1, 4);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('T-Bone', 'Corte muito saboroso, com um osso em formato de T, sendo de um lado o contrafilé e do outro o filé mignon', 89, 1, 4);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Sanduíche X-Tudo', 'Sandubão com muito queijo, hamburger bovino, bacon, ovo, salada e maionese', 19, 1, 5);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Espetinho de Cupim', 'Acompanha farinha, mandioca e vinagrete', 8, 1, 6);

-- USUARIOS --
INSERT INTO usuario(nome, email, senha, data_cadastro) VALUES ('Janaina', 'janaina@engenharia.com', '123321', '2021-03-16 23:24:00');
INSERT INTO usuario(nome, email, senha, data_cadastro) VALUES ('César Romagnolo', 'cesar@engenharia.com', '123321', '2021-03-16 23:24:00');
INSERT INTO usuario(nome, email, senha, data_cadastro) VALUES ('João Magnolio', 'magjoao@catador.com', '123321', '2021-03-16 23:24:00');
INSERT INTO usuario(nome, email, senha, data_cadastro) VALUES ('Rosaina Pereira', 'rose@domestic.com', '123321', '2021-03-16 23:24:00');

-- PEDIDOS --
INSERT INTO pedido(data_cancelamento, data_confirmacao, data_criacao, data_entrega, endereco_bairro, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, status, sub_total, taxa_frete, valor_total, cliente_id, endereco_cidade_id, forma_pagamento_id, restaurante_id) VALUES ('2021-03-28 23:22:13', '2021-03-29 23:22:23', '2021-04-04 23:22:28', '2021-03-16 23:22:32', 'Bandeirantes', '13671-928', 'Na frente dos lixos de construção', 'Rua Priquito', '19', 1, 150.00, 15.00, 165.00, 1, 1, 1, 1);
INSERT INTO pedido(data_cancelamento, data_confirmacao, data_criacao, data_entrega, endereco_bairro, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, status, sub_total, taxa_frete, valor_total, cliente_id, endereco_cidade_id, forma_pagamento_id, restaurante_id) VALUES ('2021-03-28 23:22:13', '2021-03-29 23:22:23', '2021-04-04 23:22:28', '2021-03-16 23:22:32', 'Ipiranga', '13671-928', 'Perto da Lotérica ', 'Rua Vem Cem ', '6969', 1, 18.00, 5.00, 23.00, 2, 2, 2, 2);

-- RESTAURANTES PRODUTOS --
-- delete from restaurante_produtos
-- insert into restaurante_produtos(restaurante_id, produtos_id) values (1, 2);
-- insert into restaurante_produtos(restaurante_id, produtos_id) values (1, 3);
-- insert into restaurante_produtos(restaurante_id, produtos_id) values (2, 4);
-- insert into restaurante_produtos(restaurante_id, produtos_id) values (3, 6);
-- insert into restaurante_produtos(restaurante_id, produtos_id) values (4, 1);
-- insert into restaurante_produtos(restaurante_id, produtos_id) values (2, 5);