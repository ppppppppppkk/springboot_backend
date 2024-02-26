create database test9;
use test9;

create table board(
bno bigint auto_increment,
bcontent text,
bwriter varchar(20),
bdate datetime default now(),
constraint test9board_bno_pk primary key(bno)
);

select *from board;