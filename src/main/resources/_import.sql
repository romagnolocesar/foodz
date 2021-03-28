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
insert into cidade (nome, estado_id) values ('Jandaia do SUl', 2);
insert into cidade (nome, estado_id) values ('Amambaí', 3);
insert into cidade (nome, estado_id) values ('Belo Horizonte', 4);

-- RESTAURANTES ---
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_longradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Centro', '38400-999', NULL, 'Rua João Pinheiro', '1000', 'César`s Bistro', 5.00, 1, 1);
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_longradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Augusto Sanni', '38500-190', NULL, 'Rua Albertina Bueno Campana', '10', 'Cantinho Brasileiro', 3.00, 2, 2);
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_longradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Fundão', '192168-001', NULL, 'Rua Timelo Rego', '2500', 'Don Reny', 2.00, 3, 3);
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_longradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Centro', '12344-122', NULL, 'Rua da Sequencia', '1234', 'Los Molinos', 1.00, 4, 4);
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_longradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Sul Profundo', '17666-666', NULL, 'Rua Perdição Eterna', '666', 'Marmitaria Zé', 0.00, 4, 1);
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_longradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Norte Profundo', '99666-996', NULL, 'Rua Contrariante', '999', 'Novilha de Ouro', 0.00, 2, 2);
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_longradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Centro', '38400-999', NULL, 'Rua João Pinheiro', '1000', 'Iris`s Bistro', 5.00, 1, 1);
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_longradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Augusto Sanni', '38500-190', NULL, 'Rua Albertina Bueno Campana', '10', 'Cantinho do João', 3.00, 2, 2);
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_longradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Fundão', '192168-001', NULL, 'Rua Timelo Rego', '2500', 'Don Paulo', 2.00, 3, 3);
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_longradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Centro', '12344-122', NULL, 'Rua da Sequencia', '1234', 'Los Tres', 1.00, 4, 4);
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_longradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Sul Profundo', '17666-666', NULL, 'Rua Perdição Eterna', '666', 'Marmitaria Maria', 0.00, 4, 1);
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_longradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Norte Profundo', '99666-996', NULL, 'Rua Contrariante', '999', 'Novilha Besta', 0.00, 2, 2);


-- FORMAS DE PAGAMENTOS ---
insert into forma_pagamento(descricao) values ('Dinheiro');
insert into forma_pagamento(descricao) values ('Cartão Crédito');
insert into forma_pagamento(descricao) values ('Débito');
insert into forma_pagamento(descricao) values ('Vale Alimentação');
insert into forma_pagamento(descricao) values ('Vale Refeição');
insert into forma_pagamento(descricao) values ('Voucher');

-- PERMISSOES DE USUARIOS ---
insert into permissao_usuario(nome, descricao) values ('Cadastrar Novos Usuários', 'Cadastrar novos usuarios no sistema.');
insert into permissao_usuario(nome, descricao) values ('Cadastrar Novas Cozinhas', 'Cadastrar novas cozinhas no sistema.');
insert into permissao_usuario(nome, descricao) values ('Alterar Permissoes', 'Alterar as permissoes dos usuarios');

-- RESTAURANTE FORMA PAGAMENTO --
insert into restaurante_forma_pagamento(restaurante_id, forma_pagamento_id) VALUES (1, 1), (1,2), (1,3), (2,3), (3,2), (3,3);

-- PRODUTOS --
insert into produto(ativo, descricao, nome, preco, restaurante_id) VALUES (1, '10 Sushi+ 10 Hosomaki+ 5 Temaki+ 6 Hotroll', 'Combo Casal', 80, 4);
insert into produto(ativo, descricao, nome, preco, restaurante_id) VALUES (1, 'Pizza de quatro queijos de (Mussarela, Parmessao, Provolone, Catupiry)', 'Pizza Queijo', 40.5, 1);
insert into produto(ativo, descricao, nome, preco, restaurante_id) VALUES (1, 'Pizza Portuguesa de (Ervilha, Presunto, Queijo, Catupiry)', 'Pizza Portuguesa', 32.5, 1);
insert into produto(ativo, descricao, nome, preco, restaurante_id) VALUES (1, 'Macarrão Bolongnesa com molho de tomate caseiro', 'Macarrão Bolongnesa', 12.32, 2);
insert into produto(ativo, descricao, nome, preco, restaurante_id) VALUES (1, 'Hamburguer Gourmet com Molho especial', 'Hamburguer Baron II', 20, 2);
insert into produto(ativo, descricao, nome, preco, restaurante_id) VALUES (1, 'Hamburguer Gourmet de picanha com queijo emental ', 'Hamburguer Baron III', 20, 3);

-- RESTAURANTES PRODUTOS --
-- insert into restaurante_produtos(restaurante_id, produtos_id) values (1, 2);
-- insert into restaurante_produtos(restaurante_id, produtos_id) values (1, 3);
-- insert into restaurante_produtos(restaurante_id, produtos_id) values (2, 4);
-- insert into restaurante_produtos(restaurante_id, produtos_id) values (3, 6);
-- insert into restaurante_produtos(restaurante_id, produtos_id) values (4, 1);
-- insert into restaurante_produtos(restaurante_id, produtos_id) values (2, 5);