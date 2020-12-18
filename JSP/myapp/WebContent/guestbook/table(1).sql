create table tblJoin(
	id char(20) primary key,
	pwd char(20) not null,
	name char(20) not null,
	email char(30),
	hp char(40),
	grade char(2) default '0'
)COLLATE='euckr_korean_ci';

create table tblGuestBook(
	num int primary key auto_increment,
	id char(20) not null,
	contents text,
	ip char(15) not null,
	regdate date,
	regtime datetime,
	secret char(2) default '0'
)COLLATE='euckr_korean_ci';

create table tblComment(
 	cnum int primary key auto_increment,
 	num int not null,
 	cid char(20) not null,
 	comment text,
 	cip char(15) not null,
 	cregDate date
)COLLATE='euckr_korean_ci';




