drop database if exists memberdb;
create database memberdb;
use memberdb;

create table member(
   mno int auto_increment,
    mname varchar(10) not null,
    mphone varchar(13) not null,
    
    primary key(mno)
);

insert into member(mname, mphone) values ('일사람', '010-0000-0001');
insert into member(mname, mphone) values ('이사람', '010-0000-0002');
insert into member(mname, mphone) values ('삼사람', '010-0000-0003');
insert into member(mname, mphone) values ('사사람', '010-0000-0004');
insert into member(mname, mphone) values ('오사람', '010-0000-0005');
insert into member(mname, mphone) values ('육사람', '010-0000-0006');

select*from member;

create table pay(
   pno int auto_increment,
   payreason varchar(30),
    pay int,
    pdate datetime default now(),
    
    mno int,
    
    primary key(pno),
    foreign key(mno) references member(mno)
    
);

insert into pay(payreason, pay, mno) values ('1월 급여',  10000 , 1);
insert into pay(payreason, pay, mno) values ('2월 급여',  20000 , 1);
insert into pay(payreason, pay, mno) values ('3월 급여',  30000 , 1);
insert into pay(payreason, pay, mno) values ('4월 급여',  40000 , 1);
insert into pay(payreason, pay, mno) values ('5월 급여',  50000 , 1);
insert into pay(payreason, pay, mno) values ('6월 급여',  60000 , 1);
insert into pay(payreason, pay, mno) values ('7월 급여',  70000 , 1);
insert into pay(payreason, pay, mno) values ('8월 급여',  80000 , 1);
insert into pay(payreason, pay, mno) values ('9월 급여',  90000 , 1);

insert into pay(payreason, pay, mno) values ('1월 급여',  10000 , 2);
insert into pay(payreason, pay, mno) values ('2월 급여',  20000 , 2);
insert into pay(payreason, pay, mno) values ('3월 급여',  30000 , 2);
insert into pay(payreason, pay, mno) values ('4월 급여',  40000 , 2);
insert into pay(payreason, pay, mno) values ('5월 급여',  50000 , 2);
insert into pay(payreason, pay, mno) values ('6월 급여',  60000 , 2);
insert into pay(payreason, pay, mno) values ('7월 급여',  70000 , 2);
insert into pay(payreason, pay, mno) values ('8월 급여',  80000 , 2);
insert into pay(payreason, pay, mno) values ('9월 급여',  90000 , 2);

select * from pay;