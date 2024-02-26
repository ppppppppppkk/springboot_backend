drop database if exists springweb;
create database springweb;
use springweb;

drop table if exists todo;
create table todo(
	id int auto_increment,
    content varchar(30),
    deadline date,
    state boolean default false,
    constraint todo_pk_id primary key(id)
);
select * from todo;


drop table if exists article;
create table article(
	id bigint auto_increment,
    title varchar(255),
    content varchar(255),
    constraint article_pk_id primary key(id)
);

select * from article;


use springweb;
drop table if exists member;
create table member(
	no bigint auto_increment , -- 회원번호
    id varchar(30) not null unique , -- 회원아이디
    pw varchar(30) not null ,		-- 회원 비번
    name varchar(20) not null , 	-- 회원 이름
    email varchar(50) ,
    phone varchar(13) not null unique,
    img text , -- 프로필 사진 경로
    constraint member_no_pk primary key(no)

);

select * from member;


