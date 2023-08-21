create table if not exists coin_detail_default_list_mapping
(
    id             int primary key auto_increment,
    default_list_id int         not null,
    symbol         varchar(20) not null
);

truncate table coin_detail;

ALTER TABLE coin_detail
    DROP COLUMN default_list_id;

ALTER TABLE coin_detail
    DROP COLUMN id;

ALTER TABLE coin_detail ADD PRIMARY KEY (symbol);