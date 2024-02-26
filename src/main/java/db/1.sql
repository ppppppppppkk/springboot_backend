
/*
	데이터베이스	: 데이터(자료) 집합/모임 
		- 관계형 데이터베이스(RDMBS) : 행/열 이루어진 데이터모임(테이블)이면서 테이블간의 관계
		- SQL : 데이터베이스에서 사용되는 데이터처리 언어.
			DDL : 정의어 = DROp , CREATE
            DML : 조작어
		DML 조작어 DATA Definition Language
    1. insert : 레코드 삽입
		1. 모든 필드 : insert into 테이블명 values(값1,값2);
        2. 특정 필드 : insert into 테이블명 values(필드명, 필드명) values (값1, 값2)
	2. select : 레코드 검색
		1. 모든 필드(*와일드카드) 의 레코드 검색 : select * from 테이블명
	3. update : 레코드의 필드 값 변경
		1. update 테이블명 set 수정할필드명 = 수정할 값 , 수정할필드명 = 수정할값;
	4. delete : 레코드 삭제
		1. delete from 테이블명;

*/
drop database if exists test4;
create database test4;
use test4;

drop database if exists member;
create table member(
	mno int not null unique,
    mid varchar(30) not null unique,
    mdate datetime default now(),		#회원가입 날짜/시간 타입, now() 현재 날짜/시간 반환해주는 sql함수 
	primary key( mno )
);

insert into member(mno, mid) values(1,"qwe");
insert into member(mno, mid) values(3,"zxcv");

select * from member;

delete from member; #모든 회원들의 정보를 제거한다.alter

#회원 아이디 변경한다
update member set mid = 'asd';

#===============================================================

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

create table board(
	bno int primary key auto_increment,
    btitle varchar(30) not null,
    bcontent mediumblob not null,
    btime datetime not null default now(),
    bviews int not null default 0,
    mno int,
    gno int,
    foreign key( mno ) references member( mno ),
    foreign key( gno ) references category( gno )
);
select *from board;

drop table if exists coment;
create table coment ( #댓글
	cno int primary key auto_increment,
    ccontent varchar(100),
    bno int,
    mno int,
    foreign key(mno) references member(mno),
    foreign key(bno) references board(bno)
);

select *from coment;















