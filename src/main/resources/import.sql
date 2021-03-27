-- COZINHAS ---
insert into cozinha (nome) values ('Tailandesa');
insert into cozinha (nome) values ('Indiana');
insert into cozinha (nome) values ('Japonesa');
insert into cozinha (nome) values ('Brasileira');

-- RESTAURANTES ---
insert into restaurante (nome, taxa_frete, cozinha_id) values ('César`s Bistro', 5, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Cantinho Brasileiro', 3, 2);
insert into restaurante (nome, taxa_frete,  cozinha_id) values ('Don Reny', 2, 3);
insert into restaurante (nome, taxa_frete,  cozinha_id) values ('Los Molinos', 1, 4);
insert into restaurante (nome, taxa_frete,  cozinha_id) values ('Embarcata Solana', 0, 1);
insert into restaurante (nome, taxa_frete,  cozinha_id) values ('Marmitaria Zé', 0, 4);
insert into restaurante (nome, taxa_frete,  cozinha_id) values ('Novilha de Ouro', 0, 2);

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

-- RESTAURANTE FORMA PAGAMENTO --
insert into restaurante_forma_pagamento(restaurante_id, forma_pagamento_id) VALUES (1, 1), (1,2), (1,3), (2,3), (3,2), (3,3);;