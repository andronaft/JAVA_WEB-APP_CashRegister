create schema if not exists DB;

create table WORKER
(
	ID INT auto_increment,
	NAME TEXT not null,
	SURNAME TEXT not null,
	LOGIN TEXT not null,
	PASSWORD TEXT not null,
	ROLE TEXT not null,
	constraint WORKER_PK
		primary key (ID)
);

create table GOOD
(
	ID INT auto_increment,
	NAME TEXT not null,
	PRICE FLOAT not null,
	TYPE TEXT not null,
	constraint GOOD_PK
		primary key (ID)
);

create table TRANSACTION
(
	ID INT auto_increment,
	IDWORKER INT not null,
	GOODS TEXT not null,
	constraint TRANSACTION_PK
		primary key (ID)
);
