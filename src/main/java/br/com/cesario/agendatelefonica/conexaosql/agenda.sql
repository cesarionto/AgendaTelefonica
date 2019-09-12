create database agenda;
use agenda;
create table contatos (
	id smallint auto_increment,
	nome varchar(255),
	numero_telefone varchar(255),
	primary key (id)
)