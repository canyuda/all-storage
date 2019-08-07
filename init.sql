create database szs_storage;

use szs_storage;

create table szs_storage.t_user
(
    id bigint(20) auto_increment primary key,
    username varchar(25) not null,
    age int(11) not null
);

ALTER TABLE `t_user`
    ADD COLUMN `password` VARCHAR(50) NOT NULL AFTER `username`;
