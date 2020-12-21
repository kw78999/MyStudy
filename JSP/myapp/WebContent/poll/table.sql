DROP TABLE IF EXISTS tblPollList;

create table tblPollList(
 num int primary key auto_increment,
 question varchar(200) not null,
 sdate date,
 edate date,
 wdate date,
 type smallint default 1,
 active smallint default 1
)COLLATE='euckr_korean_ci';

DROP TABLE IF EXISTS tblPollItem;

create table tblPollItem(
 listnum int not null,
 itemnum smallint default 0,
 item varchar(50) not null,
 count int,
 primary key(listnum, itemnum)
)COLLATE='euckr_korean_ci';
