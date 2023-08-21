alter table `coin_detail` drop primary key;
alter table `coin_detail` add column `id` int not null auto_increment primary key first;