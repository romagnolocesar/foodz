-- COZINHAS ---
insert into cozinha (nome) values ('Tailandesa');
insert into cozinha (nome) values ('Indiana');
insert into cozinha (nome) values ('Japonesa');
insert into cozinha (nome) values ('Brasileira');

-- RESTAURANTES ---
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Restaurante do César', 5, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Cantinho Brasileiro', 3, 2);
insert into restaurante (nome, taxa_frete,  cozinha_id) values ('Don Reny', 2, 3);
insert into restaurante (nome, taxa_frete,  cozinha_id) values ('Los Molinos', 1, 4);

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