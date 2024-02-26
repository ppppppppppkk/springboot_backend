drop database if exists category;
drop database if exists test6;
create database test6;
use test6;

drop table if exists category;
create table category( #카테고리 작성
	gno int primary key auto_increment,
    bcategory varchar(30) not null unique
);
select * from category;

drop table if exists board;

create table board( #게시물
	bno int primary key auto_increment,
    btitle varchar(30) not null,playermembermember
    bcontent mediumblob not null,
    btime datetime not null default now(),
    bviews int not null default 0,
    mno int,
    gno int,
    foreign key(mno) references member(mno),
    foreign key(gno) references category(gno)
);
select *from board;

create table coment ( #댓글
	cno int primary key auto_increment,
    ccontent varchar(100),
    bno int,
    mno int,
    foreign key(mno) references member(mno),
    foreign key(bno) references board(bno)
);














