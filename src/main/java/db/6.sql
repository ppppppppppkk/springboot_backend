# 데이터베이스
drop database if exists epicflow;
create database epicflow;
use epicflow;

# 회원테이블
drop table if exists member;
create table member(
	mno int auto_increment primary key,		-- 회원번호
    mid varchar(16) not null unique,		-- 회원아이디
    mpw varchar(13) not null				-- 회원비밀번호
);

# 캐릭터테이블
drop table if exists player;
create table player(
	pno int auto_increment primary key,		-- 플레이어 번호
    pname varchar(8) not null unique,		-- 플레이어 이름
    mhp int default 100,					-- 최대체력
    hp int default 100,						-- 체력
    mmp int default 50,						-- 최대마나
    mp int default 50,						-- 마나
    job int default 0,						-- 직업
    level int default 1,					-- 레벨
    exp int default 0,						-- 경험치
    money int default 0,					-- 돈
    statpoint int default 0,				-- 포인트
    power int default 10,					-- 공격력
    defence int default 0,					-- 방어력
    skillpower int default 10,				-- 스킬데미지
    str int default 0,						-- 힘
    dex int default 0,						-- 민첩
    wis int default 0,						-- 지능
    eva int default 0,						-- 회피
    spd int default 0,						-- 속도
    mno int,								-- 회원번호
    foreign key(mno) references member(mno)
);

# 몬스터테이블
drop table if exists monster;
create table monster(
	monsterno int auto_increment primary key,	-- 몬스터 번호
    monstername varchar(10),					-- 몬스터 이름
    monstermhp int,								-- 몬스터 최대체력
    monsterhp int,								-- 몬스터 체력
    monsterpower int,							-- 몬스터 공격력
    monsterdefence int,							-- 몬스터 방어력
    dropgold int,								-- 드랍 골드
    dropexp int									-- 드랍 경험치
);

insert into monster (monstername,monstermhp,monsterhp,monsterpower,monsterdefence,dropgold,dropexp) values('슬라임',30,30,7,2,10,10);
insert into monster (monstername,monstermhp,monsterhp,monsterpower,monsterdefence,dropgold,dropexp) values('고블린',100,100,12,5,50,50);

select * from member;
select * from player;
select * from monster;