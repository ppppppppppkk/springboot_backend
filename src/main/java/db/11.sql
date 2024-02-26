drop database if exists Duoboard;
create database Duoboard;
use Duoboard;

drop table if exists DuoBoard1;
create table DuoBoard1(

no int auto_increment,
name varchar(10),
title longtext,
content longtext,

primary key(no)
);

select * from DuoBoard1;