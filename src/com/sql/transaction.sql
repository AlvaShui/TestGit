CREATE TABLE accounts
(
	id NUMBER(10) PRIMARY KEY,
	code NUMBER(20) NOT NULL UNIQUE,
	name VARCHAR2(20),
	balance NUMBER(10,2)
);

INSERT INTO accounts VALUES(1, 123456789, 'zhangsan', 500);

/*乐观锁的version版本控制*/

create table accounts_version(
	id NUMBER(10) PRIMARY KEY,
	version number(10),
	code NUMBER(20) NOT NULL UNIQUE,
	name VARCHAR2(20),
	balance NUMBER(10,2)
);

insert into accounts_version values(1,1,123456,'weilong',700);
/*乐观锁的timestamp版本控制*/

create table accounts_timestamp(
	id NUMBER(10) PRIMARY KEY,
	time_stamp timestamp,
	code NUMBER(20) NOT NULL UNIQUE,
	name VARCHAR2(20),
	balance NUMBER(10,2)
);

insert into accounts_timestamp values(1,SYSTIMESTAMP,123456,'weilong',700);