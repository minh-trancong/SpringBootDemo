-- auto-generated definition
create table if not exists coin_detail (
	symbol varchar(20) not null primary key,
	default_list_id int not null,
	base_asset varchar(10) not null,
	quote_asset varchar(10) not null,
	price_change_percent float not null,
	volume double not null,
	quote_volume double not null,
	created_at datetime(6),
	updated_at datetime(6)
);

create table if not exists default_list (
    id int not null primary key auto_increment,
    name varchar(20)
);

insert into default_list (name) values ('TOP_COIN');
insert into default_list (name) values ('TOP_VOLUME');