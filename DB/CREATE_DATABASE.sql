create database meuveiculo_db;
use meuveiculo_db;

create table usuario (
id int not null primary key auto_increment,
nome varchar(50) not null,
data_nascimento date not null,
usuario varchar(30) not null,
senha varchar(32) not null,
email varchar(100) not null,
foto longblob, -- converte a foto em binário
ativo varchar(3) not null default 'Sim'
);
alter table usuario add index (nome);
alter table usuario add index (usuario);

create table tipo_veiculo (
id int not null primary key auto_increment,
descricao varchar(50) not null
);
alter table tipo_veiculo add index (descricao);

create table marca_veiculo (
id int not null primary key auto_increment,
marca varchar(30) not null
);
alter table marca_veiculo add index (marca);

create table veiculo (
id int not null primary key auto_increment,
placa varchar(8) not null,
tipo_veiculo_id int not null,
marca_veiculo_id int not null,
modelo varchar(60) not null,
renavam varchar(15) not null,
cor varchar(20) not null,
ano int(4) not null,
usuario_id int not null,
foreign key(tipo_veiculo_id) references tipo_veiculo (id),
foreign key(marca_veiculo_id) references marca_veiculo(id),
foreign key(usuario_id) references usuario(id)
);
alter table veiculo add index (placa);
alter table veiculo add index (modelo);

create table pais(
id int not null primary key auto_increment,
nome varchar(100) not null
);
alter table pais add index (nome);

create table estado(
id int not null primary key auto_increment,
nome varchar(100) not null,
pais_id int not null,
foreign key(pais_id) references pais(id)
);
alter table estado add index (nome);

create table tipo_fornecedor(
id int not null primary key auto_increment,
descricao varchar(100) not null
);
alter table tipo_fornecedor add index (descricao);

create table fornecedor (
id int not null primary key auto_increment,
nome varchar(100) not null,
cpf_cnpj varchar(14) not null,
tipo_fornecedor_id int not null,
telefone_fixo varchar(10),
telefone_celular varchar(11) not null,
endereco varchar(255) not null,
cep int(8) not null,
estado_id int not null,
pais_id int not null,
contato varchar(50) not null,
foreign key(tipo_fornecedor_id) references tipo_fornecedor(id),
foreign key(estado_id) references estado(id),
foreign key(pais_id) references pais(id)
);
alter table fornecedor add index (nome);
alter table fornecedor add index (cpf_cnpj);

create table tipo_manutencao(
id int not null primary key auto_increment,
descricao varchar(100) not null
);
alter table tipo_manutencao add index (descricao);

create table manutencao(
id int not null primary key auto_increment,
veiculo_id int not null,
fornecedor_id int not null,
tipo_manutencao_id int not null,
descricao varchar(2000) not null,
data_manutencao date not null,
nota_fiscal int(20) not null,
valor double not null,
foreign key(veiculo_id) references veiculo(id),
foreign key(fornecedor_id) references fornecedor(id),
foreign key(tipo_manutencao_id) references tipo_manutencao(id)
);
alter table manutencao add index (data_manutencao);

create table tipo_combustivel(
id int not null primary key auto_increment,
descricao varchar(50) not null
);
alter table tipo_combustivel add index (descricao);

create table abastecimento(
id int not null primary key auto_increment,
veiculo_id int not null,
fornecedor_id int not null,
tipo_combustivel_id int not null,
data_abastecimento date not null,
odometro_anterior int(7) not null,
odometro_atual int(7) not null,
valor_unitario double not null,
quantidade int not null,
valor_total double not null,
media double not null,
observacoes varchar(255),
foreign key(veiculo_id) references veiculo(id),
foreign key(fornecedor_id) references fornecedor(id),
foreign key(tipo_combustivel_id) references tipo_combustivel(id)
);

create table lista_odometro(
id int not null primary key auto_increment,
veiculo_id int not null,
ultimo_odometro int(7) not null,
data_odometro date not null,
abastecimento_id int not null,
foreign key (abastecimento_id) references abastecimento(id),
foreign key (veiculo_id) references veiculo(id)
);

create table tipo_despesa(
id int not null primary key auto_increment,
descricao varchar(50) not null
);
alter table tipo_despesa add index (descricao);

create table despesa(
id int not null primary key auto_increment,
tipo_despesa_id int not null,
descricao varchar(150) not null,
data_despesa date not null,
valor double not null,
observacoes varchar(900),
foreign key(tipo_despesa_id) references tipo_despesa(id)
);
alter table despesa add index (descricao);











