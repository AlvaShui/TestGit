/*set*/
create table items_set(
	id number(10) primary key,
	name varchar(10)
);

create table images_set(
	filename varchar(20),
	items_id number(10) references items_set(id),
	primary key(filename,items_id)
);

/*list*/

create table items_list(
	id number(10) primary key,
	name varchar(10)
);

create table images_list(
	position number(10),
	filename varchar(20),
	items_id number(10) references items_list(id),
	primary key(position,filename)
);

/*bag*/

create table items_bag(
	id number(10) primary key,
	name varchar(10)
);

create table images_bag(
	id number(10) primary key,
	filename varchar(20),
	items_id number(10) references items_bag(id)
);

/*map*/

create table items_map(
	id number(10) primary key,
	name varchar(10)
);

create table images_map(
	filename varchar(20),
	imagename varchar(10),
	items_id number(10) references items_map(id),
	primary key(items_id,iamgename)
);