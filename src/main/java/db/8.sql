drop database if exists test10;
create database test10;
use test10;

# 1. 회원테이블
drop table if exists member;
create table member(            # 아이돌 그룹
   mid char(8) not null ,         # 식별키       최대 8자리
    mname varchar(10) not null ,   # 그룹명      최대 10자리
    mnumber int not null ,         # 인원수      정수 +-21억정도
    maddr char(2) not null ,       # 지역      최대 2자리
    mphone1 char(3) ,            # 지역번호   최대 2자리 
    mphone2 char(8) ,            # 전화번호    최대 8자리
    mheight smallint ,            # 평균키       정수 +-3만정도
   mdebut date ,               # 데뷔일       yyyy-mm-dd 
    primary key ( mid )            # 제약조건 
);
# 2. 구매테이블
drop table if exists buy;
create table buy(
   bnum int auto_increment ,          # 구매번호   정수    자동번호 부여 
    mid char(8),                  # 구매자      FK 
    bpname char(6) not null ,         # 제품명      최대 6자리 
    bgname char(4) ,                # 분류명       최대   4자리
    bprice int not null ,            # 가격       정수 
    bamout smallint not null ,         # 구매수량   정수 
    primary key(bnum) ,               # 제약조건 
    foreign key ( mid ) references member(mid) # 제약조건 
);

# 샘플데이터 
INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '', '99999999', 165, '2014.06.19');

INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '혼공SQL', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);


select * from member;
select * from buy;

select mid from member;
select mid as 회원아이디 from member; # 별칭 키워드
select mid as 회원아이디 , mname as 그룹명 from member;
select mid 회원아이디, mname 그룹명 from member;
select * from member as m;
select * from member m;

select * from member where (kor+eng+mat)/3 >= 80; 
select * from member where companyname like '%주식%';
select 레코드명 as from 별칭 키워드 where 테이블명


select * from member where mname = '블랙핑크';
select * from member where mnumber = 4;
select * from member where mnumber != 4;
select * from member where mnumber > 4;
select * from member where mnumber < 4;
select * from member where mnumber >= 5;
select * from member where mnumber <= 5;
select * from member where mheight >= 165 and mheight<= 170;
select * from member where mheight between 165 and 170;
select * from member where mheight >= 165 or mnumber > 6;
select * from member where maddr ='경기' or maddr ='전남' or maddr = '경남';
select * from member where maddr in('경기','전남','경남');
select * from member where not maddr in('경기','전남','경남');
select * from member where not mname = '블랙핑크';

select * from member where mname like '에이%';
select * from member where mname like '%핑크';
select * from member where mname like '%마%';
select * from member where mname like '에이_'; #_개수 만큼의 
select * from member where mname like '__핑크'; # __언더바 2개 이므로 블랙핑크와 에이핑크가 나온다

select 
mnumber + 10 , mnumber - 10, mnumber * 10,
mnumber / 10, mnumber div 3, mnumber mod 3
 from member; 
 
 select * from member where mphone1 = '';
 select * from member where mphone1 = null;
 select * from member where mphone1 is null;
 select * from member where mphone1 is not null;

select 5+3 더하기,
 5-3 빼기,
 5/3, 
 5*3 ,
 5 div 3 ,
 5 mod 3 ,
 5 = 3 , 
 5 != 3 ,
 5 > 3 
 from dual;
 
 #1. as 별칭 : 필드 나 테이블에 별칭 
 #2. where 조건절 : 
 
 select * from member order by mdebut;
select * from member order by mdebut asc; #오름차순
select * from member order by mdebut desc; #내림차순
 select * from member order by mheight desc , mdebut asc; 
 
 #limit : 검색 레코드 수 제한
select * from member limit 2;
select * from member limit 0 , 3;

select * from member limit 0 , 5;
select * from member limit 5 , 5;
select * from member order by mheight desc limit 3;
# select 필드명 from 테이블명 where 조건절 order by 정렬기준 limit 제한


select maddr from member;
select distinct maddr from member;
select distinct maddr , mname from member;
select distinct maddr , mphone1 from member;

select bamout from buy;
select distinct bamout from buy;
select bamout+10 from buy;
# sum 총합계
select sum(bamout) from buy;
# avg 필드의 평균 
select avg(bamout) from buy;
# max 필드의 최댓값
select max(bamout) from buy;
# min 필드의 최솟값
select min(bamout) from buy;
#count 필드명
select count( bpname ) from buy;
select count(*) from buy;

#총 판매수량 합계
select sum(bamout) from buy;
 
 # 회원아이디 별로 판매수량 합계 / 회원 마다 판매수량 합계
 
select mid from buy group by mid;
select distinct mid from buy; 

select mid as 구매자, sum(bamout) as 총수량 from buy group by mid;
select distinct mid , sum(bamout) from buy;
# 회원 아이디 별로 총 매출액[가격 * 판매수량]
select sum( bamout * bprice ) from buy;	#총매출액
select sum( bamout * bprice) as 총매출액 , mid as 회원아이디 from buy group by mid; # 회원아이디 별로 총 매출액

#회원 별(그룹) 로 판매수량 평균
#전체 판매수량 평균
select avg( bamout ) from buy;
select avg( bamout ) as 평균구매수량 , mid from buy; # X
select avg( bamout ) as 평균구매수량 , mid 구매자 from buy group by mid;

#5. 구매자 명단
select mid as 구매자 from buy;
select mid as 구매자 from buy group by mid;
select mid,bamout as 구매자 from buy group by mid; # X

#6. 회원아이디 별로 총매출액 이 1000 이상 검색
select * from buy;
select (bamout * bprice) from buy; # 각 판매별 매출액
select sum(bamout * bprice) from buy; # 각 판매별 총 매출액
select * from buy where (bamout*bprice) >= 1000; # 각 판매별 매출액이 1000이상
select * from buy where sum (bamout*bprice) >= 1000;
select * from buy where bamout*bprice; # where 뒤에는 논리 결과물 T/F

		

select mid 구매자 , sum( bamout * bprice) 총매출액 from buy group by mid;

		# VS
# having 그룹에 해당하는 조건절 vs where 그룹에 해당하지 않는 조건절 
select mid 구매자 , sum( bamout * bprice) 총매출액 from buy group by mid having sum(bamout * bprice) >= 1000;
    
# 구매 수량이 3개 이상인 회원아이디 별로 총매출액 이 1000이상 검색
select * from buy;
select * from buy where bamout >= 3;
select sum(bamout * bprice) from buy where bamout >= 3 group by mid;
select sum(bamout * bprice) from buy where bamout >= 3 group by mid having sum(bamout * bprice ) >= 1000;
    
 
        
        
        
#1. as 별칭 
#2. where 조건절 
/*
산술 : + = * / div mod
비교 : > < >= <= = !=
논리 : and or not
between 시작값 and 끝값
in(값1, 값2, 값3)
	1 % 2. _
is null
	is nou null
    
    3. order by 정렬 asc/desc
    4. limit 시작레코드수, 개수
    5. distinct
		select distinct from 테이블명 where 조건절 order by 정렬필드 /asc/desc limit 개수
	6. 	sum(필드명) : 필드 합계
		avg(필드명) : 필드 평균
		max(필드명) : 필드 최댓값
		min(필드명) : 필드 최솟값
		count(필드명) : 필드 레코드 수 ( null 제외 )
	
	select
		필드명 , * , 필드명 as 별칭 , distinct 필드명,
	from
		테이블명 , inner join 
	on
		조인조건
	where
		일반조건
	group by
		그룹필드
	having 
		그룹조건
	order by
		정렬 필드 asc/desc
	limit
		레코드수 제한
*/



/*
select : 검색/ 조회 / 색인
	select 필드명 , 필드명 from 테이블명
    select * from 테이블명
		1. where : 조건절
		2. order by : 정렬
        3. limit : 레코드 검색 제한
        - 작성 순서
			select * from 테이블명 where 조건절 order by 필드명 asc/desc limit 시작번(0),개수
        
        1. as : 별칭
        2. distinct : 필드 값 중복 제거
        - 작성 순서
        

*/










