alter table `default_list` add column `placeholder` varchar(255) not null;

update default_list set placeholder = 'Top Coin' where name = 'TOP_COIN';
update default_list set placeholder = 'Top Volume' where name = 'TOP_VOLUME';