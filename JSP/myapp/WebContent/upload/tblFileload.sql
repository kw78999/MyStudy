create table tblFileload(
 num int primary key auto_increment,
 upFile char(50) not null,
 size int default 0
)COLLATE='euckr_korean_ci';