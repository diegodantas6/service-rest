rhamon.carvalho@autoglass.com.br


create table cliente (
	id bigint NOT NULL AUTO_INCREMENT primary key,
    nome varchar(60) not null,
    data_nascimento date
);

create table produto (
	id bigint NOT NULL AUTO_INCREMENT primary key,
    nome varchar(60) not null,
    quantidade int,
    preco double
);

create table usuario (
	id bigint NOT NULL AUTO_INCREMENT primary key,
    nome varchar(60) not null,
    user varchar(20) not null,
    pass varchar(20) not null,
    foto blob
);
