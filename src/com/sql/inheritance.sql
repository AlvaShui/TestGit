/*对整个继承结构映射一张表*/
create table ct_extends(
	id number(10) primary key,
	owner VARCHAR2(15),
	code VARCHAR2(15),
	created DATE,
	bankname VARCHAR2(20),
	bankswift VARCHAR2(20),
	credit_card_type VARCHAR2(20),
	expired_month VARCHAR2(20),
	expired_year VARCHAR2(20),
	account_type varchar2(10)
);

create sequence ct_extends_seq
start with 1
increment by 1;