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

/*每个类映射一张表*/
create table ct_join_billingdetails(
	id number(10) primary key,
	owner varchar2(15),
	code varchar2(15),
	created date
);

create table ct_bankaccount(
	billing_id number(10) primary key,
	bankname VARCHAR2(20),
	bankswift VARCHAR2(20),
	foreign key(billing_id) references ct_join_billingdetails(id)
);

create table ct_creditcard(
	billing_id number(10) primary key,
	credit_card_type VARCHAR2(20),
	expired_month VARCHAR2(20),
	expired_year VARCHAR2(20),
	foreign key(billing_id) references ct_join_billingdetails(id)
);

/*每个子类映射一张表*/
create table ct_uniondetail_bankaccount(
	id number(10) primary key,
	owner varchar2(15),
	code varchar2(15),
	created date,
	bankname VARCHAR2(20),
	bankswift VARCHAR2(20)
);

create table ct_uniondetail_creditcard(
	id number(10) primary key,
	owner varchar2(15),
	code varchar2(15),
	created date,
	credit_card_type VARCHAR2(20),
	expired_month VARCHAR2(20),
	expired_year VARCHAR2(20)
);