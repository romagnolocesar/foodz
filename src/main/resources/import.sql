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
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_longradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Centro', '38400-999', NULL, 'Rua João Pinheiro', '1000', 'César`s Bistro', 5.00, 1, 1);
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_longradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Augusto Sanni', '38500-190', NULL, 'Rua Albertina Bueno Campana', '10', 'Cantinho Brasileiro', 3.00, 2, 2);
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_longradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Fundão', '192168-001', NULL, 'Rua Timelo Rego', '2500', 'Don Reny', 2.00, 3, 3);
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_longradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Centro', '12344-122', NULL, 'Rua da Sequencia', '1234', 'Los Molinos', 1.00, 4, 4);
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_longradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Sul Profundo', '17666-666', NULL, 'Rua Perdição Eterna', '666', 'Marmitaria Zé', 0.00, 4, 1);
insert into restaurante(data_atualizacao, data_cadastro, endereco_bairro, endereco_cep, endereco_complemento, endereco_longradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES ('2021-03-27 11:26:27', '2021-03-27 11:26:27', 'Norte Profundo', '99666-996', NULL, 'Rua Contrariante', '999', 'Novilha de Ouro', 0.00, 2, 2);


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