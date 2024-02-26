drop database project1;
create database project1;
use project1;

drop table if exists projecttest;
create table projecttest(
 id int auto_increment,
 title varchar(30),
 content longtext,
 primary key(id)
);

select * from projecttest;

delete from projecttest where id = 8;