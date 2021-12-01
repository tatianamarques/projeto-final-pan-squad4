INSERT INTO agencia (bairro,cep,cidade,complemento,logradouro,numero_endereco,uf,numero_agencia,ddd,numero_telefone,tipo_telefone) VALUES ('Centro', '21435678', 'São Pauto', '', 'Rua da Agência', '236', 'SP', '123-4', '011', '12340987', 'COMERCIAL');

INSERT INTO cliente (cpf,data_nascimento,email,nome) VALUES ('85953354002', '1979-03-25', 'jose@email.com', 'José da Silva Souza');
INSERT INTO cliente (cpf,data_nascimento,email,nome) VALUES ('43491283019', '1984-09-11', 'ana@email.com', 'Ana Maria Braga');
INSERT INTO endereco (bairro,cep,cidade,complemento,logradouro,numero,uf,cliente_id) VALUES ('Alvorada', '98762123', 'Viana', 'casa', 'Rua Esmeralda', '12', 'ES', '1');
INSERT INTO endereco (bairro,cep,cidade,complemento,logradouro,numero,uf,cliente_id) VALUES ('Morumbi', '123456789', 'São Paulo', 'apto 1001', 'Rua Independência', '167', 'SP', '2');

INSERT INTO telefone (ddd, numero, tipo_telefone, cliente_id) VALUES ('027', '11111-1111', 'CELULAR', '1');
INSERT INTO telefone (ddd, numero, tipo_telefone, cliente_id) VALUES ('027', '1111-2222', 'RESIDENCIAL', '1');
INSERT INTO telefone (ddd, numero, tipo_telefone, cliente_id) VALUES ('011', '22222-1111', 'CELULAR', '2');
INSERT INTO telefone (ddd, numero, tipo_telefone, cliente_id) VALUES ('011', '2222-2222', 'RESIDENCIAL', '2');

INSERT INTO conta (data_abertura, esta_bloqueada, numero, saldo, saldo_especial, senha, tipo_conta, agencia_id, cliente_id) VALUES ('2021-01-19', 0,'1111-1', 500, 0,'1234','CORRENTE', 1, 1);
INSERT INTO conta (data_abertura, esta_bloqueada, numero, saldo, saldo_especial, senha, tipo_conta,agencia_id, cliente_id) VALUES ('2020-07-03', 0,'2222-2', 1500, 0,'1234','POUPANCA', 1, 2);
