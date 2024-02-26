drop database if exists spring1;
create database spring1;
use spring1;

drop table if exists springtest1;
create table springtest1(
	no int auto_increment,
    id varchar(30),
    pw varchar(30),
    name varchar(20),
    email varchar(40),
    phone char(16),
    img blob not null,
    primary key(no)
);
select * from springtest1;