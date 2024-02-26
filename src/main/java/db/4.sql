#제약 alte

# 1. 제약조건에 이름 달기(삭제,수정)
# 무결성 옵션
	# on [delete/update] [restrict/cascade/set null]
	# on delete restrict pk -fk 데이터가 서로 참조하고 있는 데이터가 존재하면 취소/실행불가
    # on delete cascade  pk - fk 데이터가 서로 참조하고 있는 데이터가 개체가 존재하면 같이 삭제 이거 많이 쓰자
    # on delete set null pk - fk 데이터가 서로 참조하고 있는 데이터/개체 조냊하면 pk삭제하고 fk null로 설정
    # on update restrict
    # on update cascade
    # on update set null
drop database if exists test7;
create database test7;
use test7;

drop table if exists member;
#1. 회원테이블
create table member(
	mno int auto_increment,
    mid varchar(30),
    mpw varchar(30),
	constraint member_pk primary key(mno)
);
drop table if exists board;
#2. 게시판테이블
create table board(
	bno int auto_increment,
    btitle text, 
    bcontent text,
    mno int,
    primary key(bno),
	constraint boardmno_pk foreign key(mno) references member(mno) on update set null
);

#확인
insert into member(mid,mpw) values('ezez01','1234');
insert into member(mid,mpw) values('ezez02','6767');
insert into board(btitle,bcontent,mno) values('자바','안녕하세요',1);

select *from board;
select *from member;

#delete from member where mno = 1;

update member set mmo = 3 where mno = 1;


insert into member(mid,mpw) values('ezez03','1855');
insert into member(mid,mpw) values('ezez04','1356');
insert into member(mid,mpw) values('ezez05','5656');
insert into board(btitle,bcontent,mno) values('자바','안녕하세요',2);
insert into board(btitle,bcontent,mno) values('파이썬','안녕하세요',1);


select mno from board where bno = 1;
select mno from board where bno = 2;

select mid from member where mno = 2;
#=======================================관계 가 있는 테이블 간의 조인
select * from member;
select * from board;

select * from member,board;


#select * from member,board where mno = mno; 
#필드명 앞에 테이블을 붙인다()!!!
select * from member,board where member.mno = board.mno; 
# 관례적으로 테이블명에 별칭을 이용(원본가 상관없음)
select * from member m, board b where m.mno = b.mno;
#(이거쓰자)!!!
select * from member natural join board;
#테이블이 여러개면 뭐가 참조 했는지 모르기 때문에 테이블 여러개 사용 시 밑에 거를 쓰자
select * from member join board on member.mno = board.mno;

select * from member join board using(mno);

select * from member inner join board on member.mno = board.mno; # 외우셈 !!

select * from  member right outer join board on member.mno = board.mno;
select * from member left outer join board on member.mno = board.mno;








update board set bcontent = '안녕';
update board set bcontent = '하이';
update board set bcontent = 'ㅇㅇ' where bcontent = 7;

 


