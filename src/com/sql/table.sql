create table student(
	id number primary key,
	name varchar(20) not null,
	sex varchar(4),
	age number,
	check(sex in('ÄÐ','Å®'))
);

create sequence stu_seq
start with 1
increment by 1;

CREATE TABLE BOOK(
	isbn varchar2(200) primary key,
	name varchar(15),
	author varchar2(10),
	price number(10,2)
);

CREATE TABLE BOOK2(
	isbn varchar2(200),
	name varchar(15),
	author varchar2(10),
	price number(10,2),
	primary key(isbn,name)
);