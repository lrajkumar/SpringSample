#create database sample

use sample;

create table user (id varchar(255) primary key, first_name varchar(255), last_name varchar(255), user_role varchar(255));

insert into user values ('ID1', 'Raj', 'Kumar', 'Admin');
insert into user values ('ID2', 'Raja', 'Test', 'Reader');

select * from user where user_role = 'Admin';


select
        user0_.id as id1_0_,
        user0_.first_name as first_na2_0_,
        user0_.last_name as last_nam3_0_,
        user0_.user_role as user_rol4_0_
    from
        t_user user0_
    where
        user0_.user_role='Admin'