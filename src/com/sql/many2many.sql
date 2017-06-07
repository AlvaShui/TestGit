create table ct_engineer(
	id number(10) primary key,
	name varchar2(20) not null,
	gender varchar2(10),
	age number(3) check(age between 1 and 100),
	company vauchar2(30)
);

create table ct_technology(
	id number(10) primary key,
	name varchar2(20) not null,
	category varchar2(20) not null
);

create table ct_engineer_technology(
	engineer_id number(10),
	technology_id number(10),
	primary key(engineer_id,technology_id),
	foreign key(engineer_id) references ct_engineer(id),
	foreign key(technology_id) references ct_technology(id)
);

create sequence ct_engineer_seq
start with 1
increment by 1;

create sequence ct_technology_seq
start with 1
increment by 1;