create table t_order(
	id number(10) primary key,
	order_date date not null,
	shipper_date date,
	total number(10,2)
);

CRATE table t_orderline(
	id number(10) primary key,
	price number(10,2),
	quantity number(10),
	product varchar2(30),
	order_id number(10) reference t_order(id)
);

create sequence t_order_seq
start with 1
increment by1;

create sequence t_orderline_seq
start with 1
increment by1;
